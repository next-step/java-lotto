package lotto.domain;

import lotto.domain.ticket.Lotto;
import lotto.domain.ticket.LottoBundle;
import lotto.enums.LottoRank;
import lotto.vo.LottoResult;
import org.junit.Test;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;

public class LottoRunnerTest {
    @Test
    public void LottoBundle의_매치카운트_가져오기() {
        // given
        int bonusNumber = 45;
        int differentBonusNumber = 44;
        Lotto winner = new Lotto(Arrays.asList(1, 2, 3, 4, 5, 6), bonusNumber);
        Lotto second = new Lotto(Arrays.asList(1, 2, 3, 4, 5, 16), bonusNumber);
        Lotto third = new Lotto(Arrays.asList(1, 2, 3, 4, 5, 16), differentBonusNumber);
        Lotto fail = new Lotto(Arrays.asList(11, 12, 13, 14, 15, 16), bonusNumber);

        LottoBundle lottoBundle = new LottoBundle(Arrays.asList(second, third, fail));

        // when
        long[] matchCounts = LottoRunner.getMatchCounts(winner, lottoBundle);

        // then
        assertThat(matchCounts[LottoRank.FIRST.getMatchCount()]).isEqualTo(0);
        assertThat(matchCounts[LottoRank.SECOND.getMatchCount()]).isEqualTo(1);
        assertThat(matchCounts[LottoRank.THIRD.getMatchCount()]).isEqualTo(1);
        assertThat(matchCounts[LottoRank.FOURTH.getMatchCount()]).isEqualTo(0);
        assertThat(matchCounts[LottoRank.FIFTH.getMatchCount()]).isEqualTo(0);
    }

    @Test
    public void LottoBundle의_당첨_결과() {
        // given
        int bonusNumber = 45;
        int differentBonusNumber = 44;
        Lotto winner = new Lotto(Arrays.asList(1, 2, 3, 4, 5, 6), bonusNumber);
        Lotto first = new Lotto(Arrays.asList(1, 2, 3, 4, 5, 6), differentBonusNumber);
        Lotto third = new Lotto(Arrays.asList(1, 2, 3, 4, 5, 16), differentBonusNumber);
        Lotto fail = new Lotto(Arrays.asList(11, 12, 13, 14, 15, 16), bonusNumber);

        LottoBundle lottoBundle = new LottoBundle(Arrays.asList(first, third, fail));

        // when
        LottoResult lottoResult = LottoRunner.runLotto(winner, lottoBundle);

        // then
        assertThat(lottoResult.getNumberOfWin(LottoRank.FIRST)).isEqualTo(1);
        assertThat(lottoResult.getNumberOfWin(LottoRank.SECOND)).isEqualTo(0);
        assertThat(lottoResult.getNumberOfWin(LottoRank.THIRD)).isEqualTo(1);
        assertThat(lottoResult.getNumberOfWin(LottoRank.FOURTH)).isEqualTo(0);
        assertThat(lottoResult.getNumberOfWin(LottoRank.FIFTH)).isEqualTo(0);
    }
}
