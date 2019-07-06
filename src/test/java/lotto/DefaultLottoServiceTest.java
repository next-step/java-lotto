package lotto;

import lotto.common.Csv;
import lotto.common.PositiveNumber;
import lotto.domain.DefaultLottoService;
import lotto.domain.LottoService;
import lotto.domain.ticket.*;
import lotto.domain.winning.LottoWinningAmount;
import lotto.dto.LottoPurchaseRequestDto;
import lotto.dto.LottoResultDto;
import lotto.dto.LottoWinningRequestDto;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.Collections;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatExceptionOfType;

public class DefaultLottoServiceTest {

    @Test
    @DisplayName("로또티켓을 정상적으로 발급하는지 확인한다")
    void checkPurchaseLottoTickets() {

        LottoService lottoService = new DefaultLottoService(new MockLottoTicketGenerator(
                LottoTickets.of(Arrays.asList(
                        LottoTicket.of(Arrays.asList(1L, 2L, 3L, 4L, 5L, 6L)),
                        LottoTicket.of(Arrays.asList(7L, 8L, 9L, 10L, 11L, 12L))
                ))));

        LottoPurchaseRequestDto lottoPurchaseRequestDto = LottoPurchaseRequestDto.of(PositiveNumber.of(2000L), Collections.emptyList());
        LottoTickets lottoTickets = lottoService.purchaseLottoTickets(lottoPurchaseRequestDto);

        assertThat(lottoTickets.count()).isEqualTo(2);
        assertThat(lottoTickets.findAll().get(0).getLottoTicketNumbers()).isEqualTo("1, 2, 3, 4, 5, 6");
        assertThat(lottoTickets.findAll().get(1).getLottoTicketNumbers()).isEqualTo("7, 8, 9, 10, 11, 12");
    }

    @Test
    @DisplayName("구입금액에 맞게 로또티켓을 발급하는지 확인한다")
    void checkPurchaseLottoTickets2() {
        LottoService lottoService = new DefaultLottoService(new DefaultLottoTicketGenerator());
        LottoPurchaseRequestDto lottoPurchaseRequestDto = LottoPurchaseRequestDto.of(PositiveNumber.of(71000L), Collections.emptyList());
        LottoTickets lottoTickets = lottoService.purchaseLottoTickets(lottoPurchaseRequestDto);

        assertThat(lottoTickets.count()).isEqualTo(71);
    }

    @Test
    @DisplayName("당첨결과를 정상적으로 출력하는지 확인한다")
    void checkWinningAmount() {
        LottoService lottoService = new DefaultLottoService(new MockLottoTicketGenerator(
                LottoTickets.of(Arrays.asList(
                        LottoTicket.of(Arrays.asList(1L, 2L, 3L, 4L, 5L, 6L)),
                        LottoTicket.of(Arrays.asList(7L, 8L, 9L, 10L, 11L, 12L))
                ))));

        LottoPurchaseRequestDto lottoPurchaseRequestDto = LottoPurchaseRequestDto.of(PositiveNumber.of(2000L), Collections.emptyList());
        LottoTickets lottoTickets = lottoService.purchaseLottoTickets(lottoPurchaseRequestDto);

        LottoWinningRequestDto lottoWinningRequestDto = LottoWinningRequestDto.of(Csv.ofString("1,2,3,14,15,16"), PositiveNumber.of(45), lottoTickets);
        LottoResultDto lottoResultDto = lottoService.checkWinningAmount(lottoWinningRequestDto);

        assertThat(lottoResultDto.getWinningResult().getWinningCount(LottoWinningAmount.THREE_MATCH)).isEqualTo(1);
    }

    @Test
    @DisplayName("수익률을 정상적으로 출력하는지 확인한다")
    void checkWinningAmount2() {
        LottoService lottoService = new DefaultLottoService(new MockLottoTicketGenerator(
                LottoTickets.of(Arrays.asList(
                        LottoTicket.of(Arrays.asList(1L, 2L, 3L, 4L, 5L, 6L)),
                        LottoTicket.of(Arrays.asList(7L, 8L, 9L, 10L, 11L, 12L))
                ))));

        LottoPurchaseRequestDto lottoPurchaseRequestDto = LottoPurchaseRequestDto.of(PositiveNumber.of(2000L), Collections.emptyList());
        LottoTickets lottoTickets = lottoService.purchaseLottoTickets(lottoPurchaseRequestDto);

        LottoWinningRequestDto lottoWinningRequestDto = LottoWinningRequestDto.of(Csv.ofString("1,2,3,14,15,16"), PositiveNumber.of(45), lottoTickets);
        LottoResultDto lottoResultDto = lottoService.checkWinningAmount(lottoWinningRequestDto);

        assertThat(lottoResultDto.getEarningRate()).isEqualTo(2.5);
    }
}
