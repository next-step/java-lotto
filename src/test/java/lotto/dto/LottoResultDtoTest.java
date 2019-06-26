package lotto.dto;

import lotto.domain.*;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;

public class LottoResultDtoTest {

    @Test
    @DisplayName("로또 당첨결과를 정상적으로 셋팅하는지 확인한다")
    void setLottoResult() {
        // given
        LottoTickets lottoTickets = LottoTickets.of(Arrays.asList(
                LottoTicket.of(Arrays.asList(1L, 2L, 3L, 14L, 15L, 16L)),
                LottoTicket.of(Arrays.asList(1L, 2L, 3L, 14L, 15L, 16L)),
                LottoTicket.of(Arrays.asList(1L, 2L, 3L, 4L, 15L, 16L)),
                LottoTicket.of(Arrays.asList(1L, 2L, 3L, 4L, 5L, 16L)),
                LottoTicket.of(Arrays.asList(1L, 2L, 3L, 4L, 5L, 6L)))
        );
        LottoTicket winningTicket = LottoTicket.of(Arrays.asList(1L, 2L, 3L, 4L, 5L, 6L));
        LottoWinningResult lottoWinningResult = LottoWinningChecker.of(lottoTickets, winningTicket).getWinnigResult();
        PurchaseAmount purchaseAmount = PurchaseAmount.of(LottoTicket.PRICE * lottoTickets.count());
        // when
        LottoResultDto lottoResultDto = LottoResultDto.of(lottoWinningResult, purchaseAmount);
        assertThat(lottoResultDto.getThreeMatch().getTicketCount()).isEqualTo(2);
        assertThat(lottoResultDto.getThreeMatch().getWinningAmount()).isEqualTo(LottoWinningAmount.THREE_MATCH.getWinningAmount());

        assertThat(lottoResultDto.getFourMatch().getTicketCount()).isEqualTo(1);
        assertThat(lottoResultDto.getFourMatch().getWinningAmount()).isEqualTo(LottoWinningAmount.FOUR_MATCH.getWinningAmount());

        assertThat(lottoResultDto.getFiveMatch().getTicketCount()).isEqualTo(1);
        assertThat(lottoResultDto.getFiveMatch().getWinningAmount()).isEqualTo(LottoWinningAmount.FIVE_MATCH.getWinningAmount());

        assertThat(lottoResultDto.getSixMatch().getTicketCount()).isEqualTo(1);
        assertThat(lottoResultDto.getSixMatch().getWinningAmount()).isEqualTo(LottoWinningAmount.SIX_MATCH.getWinningAmount());

        assertThat(lottoResultDto.getEarningRate()).isEqualTo(400312.0);
    }
}
