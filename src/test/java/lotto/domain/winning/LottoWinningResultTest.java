package lotto.domain.winning;

import lotto.domain.ticket.LottoTicket;
import lotto.domain.ticket.LottoTickets;
import lotto.domain.winning.EarningRate;
import lotto.domain.winning.LottoWinningAmount;
import lotto.domain.winning.LottoWinningResult;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;

public class LottoWinningResultTest {

    @Test
    @DisplayName("로또번호가 모두 일치하지 않을때 당첨금을 확인한다")
    void checkWinningAmount() {
        // given
        LottoTickets lottoTickets = LottoTickets.of(Arrays.asList(
                LottoTicket.of(Arrays.asList(21L, 22L, 23L, 24L, 25L, 26L), 45),
                LottoTicket.of(Arrays.asList(21L, 22L, 23L, 24L, 25L, 26L), 45),
                LottoTicket.of(Arrays.asList(21L, 22L, 23L, 24L, 25L, 26L), 45),
                LottoTicket.of(Arrays.asList(21L, 22L, 23L, 24L, 25L, 26L), 45),
                LottoTicket.of(Arrays.asList(21L, 22L, 23L, 24L, 25L, 26L), 45))
        );
        LottoTicket winningTicket = LottoTicket.of(Arrays.asList(1L, 2L, 3L, 4L, 5L, 6L), 45);
        // given
        LottoWinningResult lottoWinningResult = LottoWinningResult.of(lottoTickets, winningTicket);
        // when
        Long winningAmount = lottoWinningResult.getTotalWinningAmount();
        // then
        assertThat(winningAmount).isEqualTo(0);
    }

    @Test
    @DisplayName("로또번호가 3개 일치할때 당첨금을 확인한다")
    void checkWinningAmount2() {
        // given
        LottoTickets lottoTickets = LottoTickets.of(Arrays.asList(
                LottoTicket.of(Arrays.asList(1L, 2L, 3L, 24L, 25L, 26L), 45),
                LottoTicket.of(Arrays.asList(2L, 22L, 23L, 24L, 25L, 26L), 45),
                LottoTicket.of(Arrays.asList(3L, 22L, 23L, 24L, 25L, 26L), 45),
                LottoTicket.of(Arrays.asList(4L, 22L, 23L, 24L, 25L, 26L), 45),
                LottoTicket.of(Arrays.asList(5L, 22L, 23L, 24L, 25L, 26L), 45))
        );
        LottoTicket winningTicket = LottoTicket.of(Arrays.asList(1L, 2L, 3L, 4L, 5L, 6L), 45);
        LottoWinningResult lottoWinningResult = LottoWinningResult.of(lottoTickets, winningTicket);
        // when
        Long winningAmount = lottoWinningResult.getTotalWinningAmount();
        // then
        assertThat(winningAmount).isEqualTo(LottoWinningAmount.THREE_MATCH.getWinningAmount());
    }

    @Test
    @DisplayName("로또번호가 4개 일치할때 당첨금을 확인한다")
    void checkWinningAmount3() {
        // given
        LottoTickets lottoTickets = LottoTickets.of(Arrays.asList(
                LottoTicket.of(Arrays.asList(1L, 2L, 3L, 4L, 25L, 26L), 45),
                LottoTicket.of(Arrays.asList(2L, 22L, 23L, 24L, 25L, 26L), 45),
                LottoTicket.of(Arrays.asList(3L, 22L, 23L, 24L, 25L, 26L), 45),
                LottoTicket.of(Arrays.asList(4L, 22L, 23L, 24L, 25L, 26L), 45),
                LottoTicket.of(Arrays.asList(5L, 22L, 23L, 24L, 25L, 26L), 45))
        );
        LottoTicket winningTicket = LottoTicket.of(Arrays.asList(1L, 2L, 3L, 4L, 5L, 6L), 45);
        LottoWinningResult lottoWinningResult = LottoWinningResult.of(lottoTickets, winningTicket);
        // when
        Long winningAmount = lottoWinningResult.getTotalWinningAmount();
        // then
        assertThat(winningAmount).isEqualTo(LottoWinningAmount.FOUR_MATCH.getWinningAmount());
    }

    @Test
    @DisplayName("로또번호가 5개 일치할때 당첨금을 확인한다")
    void checkWinningAmount4() {
        // given
        LottoTickets lottoTickets = LottoTickets.of(Arrays.asList(
                LottoTicket.of(Arrays.asList(1L, 2L, 3L, 4L, 5L, 26L), 45),
                LottoTicket.of(Arrays.asList(2L, 22L, 23L, 24L, 25L, 26L), 45),
                LottoTicket.of(Arrays.asList(3L, 22L, 23L, 24L, 25L, 26L), 45),
                LottoTicket.of(Arrays.asList(4L, 22L, 23L, 24L, 25L, 26L), 45),
                LottoTicket.of(Arrays.asList(5L, 22L, 23L, 24L, 25L, 26L), 45))
        );
        LottoTicket winningTicket = LottoTicket.of(Arrays.asList(1L, 2L, 3L, 4L, 5L, 6L), 45);
        LottoWinningResult lottoWinningResult = LottoWinningResult.of(lottoTickets, winningTicket);
        // when
        Long winningAmount = lottoWinningResult.getTotalWinningAmount();
        // then
        assertThat(winningAmount).isEqualTo(LottoWinningAmount.FIVE_MATCH.getWinningAmount());
    }

    @Test
    @DisplayName("로또번호가 6개 일치할때 당첨금을 확인한다")
    void checkWinningAmount5() {
        // given
        LottoTickets lottoTickets = LottoTickets.of(Arrays.asList(
                LottoTicket.of(Arrays.asList(1L, 2L, 3L, 4L, 5L, 6L), 45),
                LottoTicket.of(Arrays.asList(2L, 22L, 23L, 24L, 25L, 26L), 45),
                LottoTicket.of(Arrays.asList(3L, 22L, 23L, 24L, 25L, 26L), 45),
                LottoTicket.of(Arrays.asList(4L, 22L, 23L, 24L, 25L, 26L), 45),
                LottoTicket.of(Arrays.asList(5L, 22L, 23L, 24L, 25L, 26L), 45))
        );
        LottoTicket winningTicket = LottoTicket.of(Arrays.asList(1L, 2L, 3L, 4L, 5L, 6L), 45);
        LottoWinningResult lottoWinningResult = LottoWinningResult.of(lottoTickets, winningTicket);
        // when
        Long winningAmount = lottoWinningResult.getTotalWinningAmount();
        // then
        assertThat(winningAmount).isEqualTo(LottoWinningAmount.SIX_MATCH.getWinningAmount());
    }

    @Test
    @DisplayName("로또번호가 5개 일치하고 보너스번호가 같을때 당첨금을 확인한다")
    void checkBounsNumber() {
        // given
        LottoTickets lottoTickets = LottoTickets.of(Arrays.asList(
                LottoTicket.of(Arrays.asList(1L, 2L, 3L, 4L, 5L, 26L), 27),
                LottoTicket.of(Arrays.asList(2L, 22L, 23L, 24L, 25L, 26L), 45),
                LottoTicket.of(Arrays.asList(3L, 22L, 23L, 24L, 25L, 26L), 45),
                LottoTicket.of(Arrays.asList(4L, 22L, 23L, 24L, 25L, 26L), 45),
                LottoTicket.of(Arrays.asList(5L, 22L, 23L, 24L, 25L, 26L), 45))
        );
        LottoTicket winningTicket = LottoTicket.of(Arrays.asList(1L, 2L, 3L, 4L, 5L, 6L), 27);
        LottoWinningResult lottoWinningResult = LottoWinningResult.of(lottoTickets, winningTicket);
        // when
        Long winningAmount = lottoWinningResult.getTotalWinningAmount();
        // then
        assertThat(winningAmount).isEqualTo(LottoWinningAmount.FIVE_AND_BONUS_MATCH.getWinningAmount());
    }

    @Test
    @DisplayName("로또번호가 6개 일치하고 보너스번호가 같을때 당첨금을 확인한다")
    void checkBounsNumber2() {
        // given
        LottoTickets lottoTickets = LottoTickets.of(Arrays.asList(
                LottoTicket.of(Arrays.asList(1L, 2L, 3L, 4L, 5L, 6L), 27))
        );
        LottoTicket winningTicket = LottoTicket.of(Arrays.asList(1L, 2L, 3L, 4L, 5L, 6L), 27);
        LottoWinningResult lottoWinningResult = LottoWinningResult.of(lottoTickets, winningTicket);
        // when
        Long winningAmount = lottoWinningResult.getTotalWinningAmount();
        // then
        assertThat(winningAmount).isEqualTo(LottoWinningAmount.SIX_MATCH.getWinningAmount());
    }

    @Test
    @DisplayName("로또번호가 복합적으로 일치할때 당첨금을 확인한다")
    void checkWinningAmount6() {
        // given
        LottoTickets lottoTickets = LottoTickets.of(Arrays.asList(
                LottoTicket.of(Arrays.asList(1L, 2L, 3L, 24L, 25L, 26L), 45),
                LottoTicket.of(Arrays.asList(1L, 2L, 3L, 4L, 25L, 26L), 45),
                LottoTicket.of(Arrays.asList(1L, 2L, 3L, 4L, 25L, 26L), 45),
                LottoTicket.of(Arrays.asList(1L, 2L, 3L, 4L, 5L, 26L), 45),
                LottoTicket.of(Arrays.asList(1L, 2L, 3L, 4L, 5L, 6L), 45))
        );
        LottoTicket winningTicket = LottoTicket.of(Arrays.asList(1L, 2L, 3L, 4L, 5L, 6L), 45);
        LottoWinningResult lottoWinningResult = LottoWinningResult.of(lottoTickets, winningTicket);
        // when
        Long winningAmount = lottoWinningResult.getTotalWinningAmount();
        // then
        assertThat(winningAmount).isEqualTo(LottoWinningAmount.THREE_MATCH.getWinningAmount() * 2 +
                LottoWinningAmount.FOUR_MATCH.getWinningAmount() * 2 +
                LottoWinningAmount.FIVE_MATCH.getWinningAmount() +
                LottoWinningAmount.SIX_MATCH.getWinningAmount());
    }

    @Test
    @DisplayName("로또 구입금액 대비 50% 수익률을 확인한다")
    void checkEarningRate() {
        // given
        LottoTickets lottoTickets = LottoTickets.of(Arrays.asList(
                LottoTicket.of(Arrays.asList(1L, 2L, 3L, 24L, 25L, 26L), 45),
                LottoTicket.of(Arrays.asList(2L, 22L, 23L, 24L, 25L, 26L), 45),
                LottoTicket.of(Arrays.asList(3L, 22L, 23L, 24L, 25L, 26L), 45),
                LottoTicket.of(Arrays.asList(4L, 22L, 23L, 24L, 25L, 26L), 45),
                LottoTicket.of(Arrays.asList(5L, 22L, 23L, 24L, 25L, 26L), 45))
        );
        LottoTicket winningTicket = LottoTicket.of(Arrays.asList(1L, 2L, 3L, 4L, 5L, 6L), 45);
        LottoWinningResult lottoWinningResult = LottoWinningResult.of(lottoTickets, winningTicket);
        // when
        double earningRate = EarningRate.of(lottoWinningResult.getTotalWinningAmount(), LottoWinningAmount.THREE_MATCH.getWinningAmount() * 2).get();
        // then
        assertThat(earningRate).isEqualTo(0.5);
    }

    @Test
    @DisplayName("로또 구입금액 대비 0% 수익률을 확인한다")
    void checkEarningRate2() {
        // given
        LottoTickets lottoTickets = LottoTickets.of(Arrays.asList(
                LottoTicket.of(Arrays.asList(1L, 22L, 23L, 24L, 25L, 26L), 45),
                LottoTicket.of(Arrays.asList(2L, 22L, 23L, 24L, 25L, 26L), 45),
                LottoTicket.of(Arrays.asList(3L, 22L, 23L, 24L, 25L, 26L), 45),
                LottoTicket.of(Arrays.asList(4L, 22L, 23L, 24L, 25L, 26L), 45),
                LottoTicket.of(Arrays.asList(5L, 22L, 23L, 24L, 25L, 26L), 45))
        );
        LottoTicket winningTicket = LottoTicket.of(Arrays.asList(1L, 2L, 3L, 4L, 5L, 6L), 45);
        LottoWinningResult lottoWinningResult = LottoWinningResult.of(lottoTickets, winningTicket);
        // when
        double earningRate = EarningRate.of(lottoWinningResult.getTotalWinningAmount(), LottoWinningAmount.THREE_MATCH.getWinningAmount() * 2).get();
        // then
        assertThat(earningRate).isEqualTo(0.0);
    }

    @Test
    @DisplayName("로또 구입금액 대비 100% 수익률을 확인한다")
    void checkEarningRate3() {
        // given
        LottoTickets lottoTickets = LottoTickets.of(Arrays.asList(
                LottoTicket.of(Arrays.asList(1L, 2L, 3L, 24L, 25L, 26L), 45),
                LottoTicket.of(Arrays.asList(2L, 22L, 23L, 24L, 25L, 26L), 45),
                LottoTicket.of(Arrays.asList(3L, 22L, 23L, 24L, 25L, 26L), 45),
                LottoTicket.of(Arrays.asList(4L, 22L, 23L, 24L, 25L, 26L), 45),
                LottoTicket.of(Arrays.asList(5L, 22L, 23L, 24L, 25L, 26L), 45))
        );
        LottoTicket winningTicket = LottoTicket.of(Arrays.asList(1L, 2L, 3L, 4L, 5L, 6L), 45);
        LottoWinningResult lottoWinningResult = LottoWinningResult.of(lottoTickets, winningTicket);
        // when
        double earningRate = EarningRate.of(lottoWinningResult.getTotalWinningAmount(), LottoWinningAmount.THREE_MATCH.getWinningAmount()).get();
        // then
        assertThat(earningRate).isEqualTo(1.0);
    }
}
