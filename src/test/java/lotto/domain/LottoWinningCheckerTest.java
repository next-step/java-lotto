package lotto.domain;

import lotto.domain.ticket.LottoTicket;
import lotto.domain.ticket.LottoTickets;
import lotto.domain.winning.LottoWinningAmount;
import lotto.domain.winning.LottoWinningChecker;
import lotto.domain.winning.LottoWinningResult;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;

public class LottoWinningCheckerTest {

    @Test
    @DisplayName("로또티켓이 1개씩만 일치할때 당첨결과를 확인한다")
    void checkWinningResult() {
        // given
        LottoTickets lottoTickets = LottoTickets.of(Arrays.asList(
                LottoTicket.of(Arrays.asList(1L, 22L, 23L, 24L, 25L, 26L)),
                LottoTicket.of(Arrays.asList(2L, 22L, 23L, 24L, 25L, 26L)),
                LottoTicket.of(Arrays.asList(3L, 22L, 23L, 24L, 25L, 26L)),
                LottoTicket.of(Arrays.asList(4L, 22L, 23L, 24L, 25L, 26L)),
                LottoTicket.of(Arrays.asList(5L, 22L, 23L, 24L, 25L, 26L)))
        );
        LottoTicket winningTicket = LottoTicket.of(Arrays.asList(1L, 2L, 3L, 4L, 5L, 6L));
        // when
        LottoWinningResult lottoWinningResult = LottoWinningChecker.of(lottoTickets, winningTicket).getWinnigResult();
        // then
        assertThat(lottoWinningResult.getTotalWinningAmount()).isEqualTo(0);
        assertThat(lottoWinningResult.getEarningRate(PurchaseAmount.of(10000L))).isEqualTo(0.0);
    }

    @Test
    @DisplayName("3개가 일치하는 로또티켓이 1개 인경우 당첨결과를 확인한다")
    void checkWinningResult2() {
        // given
        LottoTickets lottoTickets = LottoTickets.of(Arrays.asList(
                LottoTicket.of(Arrays.asList(1L, 2L, 3L, 24L, 25L, 26L)),
                LottoTicket.of(Arrays.asList(2L, 22L, 23L, 24L, 25L, 26L)),
                LottoTicket.of(Arrays.asList(3L, 22L, 23L, 24L, 25L, 26L)),
                LottoTicket.of(Arrays.asList(4L, 22L, 23L, 24L, 25L, 26L)),
                LottoTicket.of(Arrays.asList(5L, 22L, 23L, 24L, 25L, 26L)))
        );
        LottoTicket winningTicket = LottoTicket.of(Arrays.asList(1L, 2L, 3L, 4L, 5L, 6L));
        // when
        LottoWinningResult lottoWinningResult = LottoWinningChecker.of(lottoTickets, winningTicket).getWinnigResult();
        // then
        assertThat(lottoWinningResult.getTotalWinningAmount()).isEqualTo(LottoWinningAmount.THREE_MATCH.getWinningAmount());
        assertThat(lottoWinningResult.getEarningRate(PurchaseAmount.of(LottoTicket.PRICE * lottoTickets.count()))).isEqualTo(1.0);
    }

    @Test
    @DisplayName("4개가 일치하는 로또티켓이 1개 인경우 당첨결과를 확인한다")
    void checkWinningResult3() {
        // given
        LottoTickets lottoTickets = LottoTickets.of(Arrays.asList(
                LottoTicket.of(Arrays.asList(1L, 2L, 3L, 4L, 25L, 26L)),
                LottoTicket.of(Arrays.asList(2L, 22L, 23L, 24L, 25L, 26L)),
                LottoTicket.of(Arrays.asList(3L, 22L, 23L, 24L, 25L, 26L)),
                LottoTicket.of(Arrays.asList(4L, 22L, 23L, 24L, 25L, 26L)),
                LottoTicket.of(Arrays.asList(5L, 22L, 23L, 24L, 25L, 26L)))
        );
        LottoTicket winningTicket = LottoTicket.of(Arrays.asList(1L, 2L, 3L, 4L, 5L, 6L));
        // when
        LottoWinningResult lottoWinningResult = LottoWinningChecker.of(lottoTickets, winningTicket).getWinnigResult();
        // then
        assertThat(lottoWinningResult.getTotalWinningAmount()).isEqualTo(LottoWinningAmount.FOUR_MATCH.getWinningAmount());
        assertThat(lottoWinningResult.getEarningRate(PurchaseAmount.of(LottoTicket.PRICE * lottoTickets.count()))).isEqualTo(10.0);
    }
}
