package lotto.domain.winning;

import lotto.domain.ticket.*;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;

public class LottoWinningResultTest {

    @Test
    @DisplayName("로또번호가 모두 일치하지 않을때 당첨금을 확인한다")
    void checkWinningAmount() {
        LottoTickets lottoTickets = LottoTickets.of(Arrays.asList(
                LottoTicket.of(LottoNumbers.of(Arrays.asList(21L, 22L, 23L, 24L, 25L, 26L))),
                LottoTicket.of(LottoNumbers.of(Arrays.asList(21L, 22L, 23L, 24L, 25L, 26L))),
                LottoTicket.of(LottoNumbers.of(Arrays.asList(21L, 22L, 23L, 24L, 25L, 26L))),
                LottoTicket.of(LottoNumbers.of(Arrays.asList(21L, 22L, 23L, 24L, 25L, 26L))),
                LottoTicket.of(LottoNumbers.of(Arrays.asList(21L, 22L, 23L, 24L, 25L, 26L))))
        );
        WinningLotto winningLotto = WinningLotto.of(LottoNumbers.of(Arrays.asList(1L, 2L, 3L, 4L, 5L, 6L)), LottoNumber.of(45));
        LottoWinningResult lottoWinningResult = LottoWinningResult.of(lottoTickets, winningLotto);
        assertThat(lottoWinningResult.getTotalWinningAmount()).isEqualTo(0);
    }

    @Test
    @DisplayName("로또번호가 3개 일치할때 당첨금을 확인한다")
    void checkWinningAmount2() {
        LottoTickets lottoTickets = LottoTickets.of(Arrays.asList(
                LottoTicket.of(LottoNumbers.of(Arrays.asList(1L, 2L, 3L, 24L, 25L, 26L))),
                LottoTicket.of(LottoNumbers.of(Arrays.asList(2L, 22L, 23L, 24L, 25L, 26L))),
                LottoTicket.of(LottoNumbers.of(Arrays.asList(3L, 22L, 23L, 24L, 25L, 26L))),
                LottoTicket.of(LottoNumbers.of(Arrays.asList(4L, 22L, 23L, 24L, 25L, 26L))),
                LottoTicket.of(LottoNumbers.of(Arrays.asList(5L, 22L, 23L, 24L, 25L, 26L))))
        );
        WinningLotto winningLotto = WinningLotto.of(LottoNumbers.of(Arrays.asList(1L, 2L, 3L, 4L, 5L, 6L)), LottoNumber.of(45));
        LottoWinningResult lottoWinningResult = LottoWinningResult.of(lottoTickets, winningLotto);
        assertThat(lottoWinningResult.getTotalWinningAmount()).isEqualTo(LottoWinningAmount.THREE_MATCH.getWinningAmount());
    }

    @Test
    @DisplayName("로또번호가 4개 일치할때 당첨금을 확인한다")
    void checkWinningAmount3() {
        LottoTickets lottoTickets = LottoTickets.of(Arrays.asList(
                LottoTicket.of(LottoNumbers.of(Arrays.asList(1L, 2L, 3L, 4L, 25L, 26L))),
                LottoTicket.of(LottoNumbers.of(Arrays.asList(2L, 22L, 23L, 24L, 25L, 26L))),
                LottoTicket.of(LottoNumbers.of(Arrays.asList(3L, 22L, 23L, 24L, 25L, 26L))),
                LottoTicket.of(LottoNumbers.of(Arrays.asList(4L, 22L, 23L, 24L, 25L, 26L))),
                LottoTicket.of(LottoNumbers.of(Arrays.asList(5L, 22L, 23L, 24L, 25L, 26L))))
        );
        WinningLotto winningLotto = WinningLotto.of(LottoNumbers.of(Arrays.asList(1L, 2L, 3L, 4L, 5L, 6L)), LottoNumber.of(45));
        LottoWinningResult lottoWinningResult = LottoWinningResult.of(lottoTickets, winningLotto);
        assertThat(lottoWinningResult.getTotalWinningAmount()).isEqualTo(LottoWinningAmount.FOUR_MATCH.getWinningAmount());
    }

    @Test
    @DisplayName("로또번호가 5개 일치할때 당첨금을 확인한다")
    void checkWinningAmount4() {
        // given
        LottoTickets lottoTickets = LottoTickets.of(Arrays.asList(
                LottoTicket.of(LottoNumbers.of(Arrays.asList(1L, 2L, 3L, 4L, 5L, 26L))),
                LottoTicket.of(LottoNumbers.of(Arrays.asList(2L, 22L, 23L, 24L, 25L, 26L))),
                LottoTicket.of(LottoNumbers.of(Arrays.asList(3L, 22L, 23L, 24L, 25L, 26L))),
                LottoTicket.of(LottoNumbers.of(Arrays.asList(4L, 22L, 23L, 24L, 25L, 26L))),
                LottoTicket.of(LottoNumbers.of(Arrays.asList(5L, 22L, 23L, 24L, 25L, 26L))))
        );
        WinningLotto winningLotto = WinningLotto.of(LottoNumbers.of(Arrays.asList(1L, 2L, 3L, 4L, 5L, 6L)), LottoNumber.of(45));
        LottoWinningResult lottoWinningResult = LottoWinningResult.of(lottoTickets, winningLotto);
        assertThat(lottoWinningResult.getTotalWinningAmount()).isEqualTo(LottoWinningAmount.FIVE_MATCH.getWinningAmount());
    }

    @Test
    @DisplayName("로또번호가 6개 일치할때 당첨금을 확인한다")
    void checkWinningAmount5() {
        LottoTickets lottoTickets = LottoTickets.of(Arrays.asList(
                LottoTicket.of(LottoNumbers.of(Arrays.asList(1L, 2L, 3L, 4L, 5L, 6L))),
                LottoTicket.of(LottoNumbers.of(Arrays.asList(2L, 22L, 23L, 24L, 25L, 26L))),
                LottoTicket.of(LottoNumbers.of(Arrays.asList(3L, 22L, 23L, 24L, 25L, 26L))),
                LottoTicket.of(LottoNumbers.of(Arrays.asList(4L, 22L, 23L, 24L, 25L, 26L))),
                LottoTicket.of(LottoNumbers.of(Arrays.asList(5L, 22L, 23L, 24L, 25L, 26L))))
        );
        WinningLotto winningLotto = WinningLotto.of(LottoNumbers.of(Arrays.asList(1L, 2L, 3L, 4L, 5L, 6L)), LottoNumber.of(45));
        LottoWinningResult lottoWinningResult = LottoWinningResult.of(lottoTickets, winningLotto);
        assertThat(lottoWinningResult.getTotalWinningAmount()).isEqualTo(LottoWinningAmount.SIX_MATCH.getWinningAmount());
    }

    @Test
    @DisplayName("로또번호가 5개 일치하고 보너스번호가 같을때 당첨금을 확인한다")
    void checkBounsNumber() {
        LottoTickets lottoTickets = LottoTickets.of(Arrays.asList(
                LottoTicket.of(LottoNumbers.of(Arrays.asList(1L, 2L, 3L, 4L, 5L, 26L))),
                LottoTicket.of(LottoNumbers.of(Arrays.asList(2L, 22L, 23L, 24L, 25L, 26L))),
                LottoTicket.of(LottoNumbers.of(Arrays.asList(3L, 22L, 23L, 24L, 25L, 26L))),
                LottoTicket.of(LottoNumbers.of(Arrays.asList(4L, 22L, 23L, 24L, 25L, 26L))),
                LottoTicket.of(LottoNumbers.of(Arrays.asList(5L, 22L, 23L, 24L, 25L, 26L))))
        );
        WinningLotto winningLotto = WinningLotto.of(LottoNumbers.of(Arrays.asList(1L, 2L, 3L, 4L, 5L, 6L)), LottoNumber.of(26));
        LottoWinningResult lottoWinningResult = LottoWinningResult.of(lottoTickets, winningLotto);
        assertThat(lottoWinningResult.getTotalWinningAmount()).isEqualTo(LottoWinningAmount.FIVE_AND_BONUS_MATCH.getWinningAmount());
    }

    @Test
    @DisplayName("로또번호가 6개 일치하고 보너스번호가 같을때 당첨금을 확인한다")
    void checkBounsNumber2() {
        LottoTickets lottoTickets = LottoTickets.of(Arrays.asList(
                LottoTicket.of(LottoNumbers.of(Arrays.asList(1L, 2L, 3L, 4L, 5L, 6L))))
        );
        WinningLotto winningLotto = WinningLotto.of(LottoNumbers.of(Arrays.asList(1L, 2L, 3L, 4L, 5L, 6L)), LottoNumber.of(27));
        LottoWinningResult lottoWinningResult = LottoWinningResult.of(lottoTickets, winningLotto);
        assertThat(lottoWinningResult.getTotalWinningAmount()).isEqualTo(LottoWinningAmount.SIX_MATCH.getWinningAmount());
    }

    @Test
    @DisplayName("로또번호가 복합적으로 일치할때 당첨금을 확인한다")
    void checkWinningAmount6() {
        LottoTickets lottoTickets = LottoTickets.of(Arrays.asList(
                LottoTicket.of(LottoNumbers.of(Arrays.asList(1L, 2L, 3L, 24L, 25L, 26L))),
                LottoTicket.of(LottoNumbers.of(Arrays.asList(1L, 2L, 3L, 24L, 25L, 26L))),
                LottoTicket.of(LottoNumbers.of(Arrays.asList(1L, 2L, 3L, 4L, 25L, 26L))),
                LottoTicket.of(LottoNumbers.of(Arrays.asList(1L, 2L, 3L, 4L, 25L, 26L))),
                LottoTicket.of(LottoNumbers.of(Arrays.asList(1L, 2L, 3L, 4L, 5L, 26L))),
                LottoTicket.of(LottoNumbers.of(Arrays.asList(1L, 2L, 3L, 4L, 5L, 6L))))
        );
        WinningLotto winningLotto = WinningLotto.of(LottoNumbers.of(Arrays.asList(1L, 2L, 3L, 4L, 5L, 6L)), LottoNumber.of(45));
        LottoWinningResult lottoWinningResult = LottoWinningResult.of(lottoTickets, winningLotto);
        assertThat(lottoWinningResult.getTotalWinningAmount()).isEqualTo(LottoWinningAmount.THREE_MATCH.getWinningAmount() * 2 +
                LottoWinningAmount.FOUR_MATCH.getWinningAmount() * 2 +
                LottoWinningAmount.FIVE_MATCH.getWinningAmount() +
                LottoWinningAmount.SIX_MATCH.getWinningAmount());
    }

    @Test
    @DisplayName("로또 구입금액 대비 50% 수익률을 확인한다")
    void checkEarningRate() {
        LottoTickets lottoTickets = LottoTickets.of(Arrays.asList(
                LottoTicket.of(LottoNumbers.of(Arrays.asList(1L, 2L, 3L, 24L, 25L, 26L))),
                LottoTicket.of(LottoNumbers.of(Arrays.asList(2L, 22L, 23L, 24L, 25L, 26L))),
                LottoTicket.of(LottoNumbers.of(Arrays.asList(3L, 22L, 23L, 24L, 25L, 26L))),
                LottoTicket.of(LottoNumbers.of(Arrays.asList(4L, 22L, 23L, 24L, 25L, 26L))),
                LottoTicket.of(LottoNumbers.of(Arrays.asList(5L, 22L, 23L, 24L, 25L, 26L))))
        );
        WinningLotto winningLotto = WinningLotto.of(LottoNumbers.of(Arrays.asList(1L, 2L, 3L, 4L, 5L, 6L)), LottoNumber.of(45));
        LottoWinningResult lottoWinningResult = LottoWinningResult.of(lottoTickets, winningLotto);
        double earningRate = EarningRate.of(lottoWinningResult.getTotalWinningAmount(), LottoWinningAmount.THREE_MATCH.getWinningAmount() * 2).get();
        assertThat(earningRate).isEqualTo(0.5);
    }

    @Test
    @DisplayName("로또 구입금액 대비 0% 수익률을 확인한다")
    void checkEarningRate2() {
        LottoTickets lottoTickets = LottoTickets.of(Arrays.asList(
                LottoTicket.of(LottoNumbers.of(Arrays.asList(1L, 22L, 23L, 24L, 25L, 26L))),
                LottoTicket.of(LottoNumbers.of(Arrays.asList(2L, 22L, 23L, 24L, 25L, 26L))),
                LottoTicket.of(LottoNumbers.of(Arrays.asList(3L, 22L, 23L, 24L, 25L, 26L))),
                LottoTicket.of(LottoNumbers.of(Arrays.asList(4L, 22L, 23L, 24L, 25L, 26L))),
                LottoTicket.of(LottoNumbers.of(Arrays.asList(5L, 22L, 23L, 24L, 25L, 26L))))
        );
        WinningLotto winningLotto = WinningLotto.of(LottoNumbers.of(Arrays.asList(1L, 2L, 3L, 4L, 5L, 6L)), LottoNumber.of(45));
        LottoWinningResult lottoWinningResult = LottoWinningResult.of(lottoTickets, winningLotto);
        double earningRate = EarningRate.of(lottoWinningResult.getTotalWinningAmount(), LottoWinningAmount.THREE_MATCH.getWinningAmount() * 2).get();
        assertThat(earningRate).isEqualTo(0.0);
    }

    @Test
    @DisplayName("로또 구입금액 대비 100% 수익률을 확인한다")
    void checkEarningRate3() {
        LottoTickets lottoTickets = LottoTickets.of(Arrays.asList(
                LottoTicket.of(LottoNumbers.of(Arrays.asList(1L, 2L, 3L, 24L, 25L, 26L))),
                LottoTicket.of(LottoNumbers.of(Arrays.asList(2L, 22L, 23L, 24L, 25L, 26L))),
                LottoTicket.of(LottoNumbers.of(Arrays.asList(3L, 22L, 23L, 24L, 25L, 26L))),
                LottoTicket.of(LottoNumbers.of(Arrays.asList(4L, 22L, 23L, 24L, 25L, 26L))),
                LottoTicket.of(LottoNumbers.of(Arrays.asList(5L, 22L, 23L, 24L, 25L, 26L))))
        );
        WinningLotto winningLotto = WinningLotto.of(LottoNumbers.of(Arrays.asList(1L, 2L, 3L, 4L, 5L, 6L)), LottoNumber.of(45));
        LottoWinningResult lottoWinningResult = LottoWinningResult.of(lottoTickets, winningLotto);
        double earningRate = EarningRate.of(lottoWinningResult.getTotalWinningAmount(), LottoWinningAmount.THREE_MATCH.getWinningAmount()).get();
        assertThat(earningRate).isEqualTo(1.0);
    }
}
