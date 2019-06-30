package lotto;

import lotto.domain.DefaultLottoService;
import lotto.domain.LottoService;
import lotto.domain.ticket.DefaultLottoTicketGenerator;
import lotto.domain.ticket.LottoTicket;
import lotto.domain.ticket.LottoTickets;
import lotto.domain.winning.LottoWinningAmount;
import lotto.dto.LottoResultDto;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatExceptionOfType;

public class DefaultLottoServiceTest {

    @Test
    @DisplayName("로또티켓을 정상적으로 발급하는지 확인한다")
    void checkPurchaseLottoTickets() {
        // given
        LottoService lottoService = new DefaultLottoService(new MockLottoTicketGenerator(
                LottoTickets.of(Arrays.asList(
                        LottoTicket.of(Arrays.asList(1L, 2L, 3L, 4L, 5L, 6L), 45),
                        LottoTicket.of(Arrays.asList(7L, 8L, 9L, 10L, 11L, 12L), 45)
                ))));
        // when
        LottoTickets lottoTickets = lottoService.purchaseLottoTickets(2000L);
        // then
        assertThat(lottoTickets.count()).isEqualTo(2);
        assertThat(lottoTickets.findAll().get(0).getLottoTicketNumbers()).isEqualTo("1, 2, 3, 4, 5, 6");
        assertThat(lottoTickets.findAll().get(1).getLottoTicketNumbers()).isEqualTo("7, 8, 9, 10, 11, 12");
    }

    @Test
    @DisplayName("구입금액에 맞게 로또티켓을 발급하는지 확인한다")
    void checkPurchaseLottoTickets2() {
        // given
        LottoService lottoService = new DefaultLottoService(new DefaultLottoTicketGenerator());
        // when
        LottoTickets lottoTickets = lottoService.purchaseLottoTickets(71000L);
        // then
        assertThat(lottoTickets.count()).isEqualTo(71);
    }

    @Test
    @DisplayName("당첨결과를 정상적으로 출력하는지 확인한다")
    void checkWinningAmount() {
        // given
        LottoService lottoService = new DefaultLottoService(new MockLottoTicketGenerator(
                LottoTickets.of(Arrays.asList(
                        LottoTicket.of(Arrays.asList(1L, 2L, 3L, 4L, 5L, 6L), 45),
                        LottoTicket.of(Arrays.asList(7L, 8L, 9L, 10L, 11L, 12L), 45)
                ))));
        // when
        LottoTickets lottoTickets = lottoService.purchaseLottoTickets(2000L);
        LottoResultDto lottoResultDto = lottoService.checkWinningAmount(lottoTickets, Arrays.asList(1L, 2L, 3L, 14L, 15L, 16L), 2000L, 45);
        // then
        assertThat(lottoResultDto.getWinningResult().getWinningCount(LottoWinningAmount.THREE_MATCH)).isEqualTo(1);
    }

    @Test
    @DisplayName("수익률을 정상적으로 출력하는지 확인한다")
    void checkWinningAmount2() {
        // given
        LottoService lottoService = new DefaultLottoService(new MockLottoTicketGenerator(
                LottoTickets.of(Arrays.asList(
                        LottoTicket.of(Arrays.asList(1L, 2L, 3L, 4L, 5L, 6L), 45),
                        LottoTicket.of(Arrays.asList(7L, 8L, 9L, 10L, 11L, 12L), 45)
                ))));
        // when
        LottoTickets lottoTickets = lottoService.purchaseLottoTickets(2000L);
        LottoResultDto lottoResultDto = lottoService.checkWinningAmount(lottoTickets, Arrays.asList(1L, 2L, 3L, 14L, 15L, 16L), 2000L, 45);
        // then
        assertThat(lottoResultDto.getEarningRate()).isEqualTo(2.5);
    }
}
