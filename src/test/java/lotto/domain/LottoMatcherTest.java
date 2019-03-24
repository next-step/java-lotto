package lotto.domain;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class LottoMatcherTest {
    @Test
    public void 한명_순위_구하기() {
        List<LottoBall> lottoBalls = new ArrayList<>();
        for (int i = 0; i < 6; i++) {
            lottoBalls.add(new LottoBall(i + 1));
        }

        String[] winningNumbers = {"1", "2", "3", "4", "5", "7"};
        String bonusNumber = "6";
        WinningLotto winningLotto = new WinningLotto(winningNumbers, bonusNumber);
        List<LottoTicket> lottoTickets = Arrays.asList(new LottoTicket(lottoBalls));

        LottoMatcher lottoMatcher = new LottoMatcher(lottoTickets, winningLotto);
        assertThat(lottoMatcher.rankResult.get(LottoRank.SECOND)).isEqualTo(1);
    }

    @Test
    public void 순위결과_집계하기() {
        List<LottoBall> lottoBalls = new ArrayList<>();
        List<LottoBall> lottoBalls2 = new ArrayList<>();
        for (int i = 0; i < 6; i++) {
            lottoBalls.add(new LottoBall(i + 1));
            lottoBalls2.add(new LottoBall(i + 3));
        }

        String[] winningNumbers = {"1", "2", "3", "4", "5", "7"};
        String bonusNumber = "6";
        WinningLotto winningLotto = new WinningLotto(winningNumbers, bonusNumber);
        List<LottoTicket> lottoTickets = Arrays.asList(new LottoTicket(lottoBalls), new LottoTicket(lottoBalls2));

        LottoMatcher lottoMatcher = new LottoMatcher(lottoTickets, winningLotto);
        assertThat(lottoMatcher.rankResult.get(LottoRank.SECOND)).isEqualTo(1);
        assertThat(lottoMatcher.rankResult.get(LottoRank.FORTH)).isEqualTo(1);
    }
}
