package lotto.domain;

import lotto.vo.LottoResult;
import org.junit.Test;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;

public class LottoCheckerTest {
    @Test
    public void LottoBundle의_당범_번호와_비교() {
        // given
        Lotto winner = new Lotto(Arrays.asList(1, 2, 3, 4, 5, 6));
        Lotto six = new Lotto(Arrays.asList(1, 2, 3, 4, 5, 6));
        Lotto one = new Lotto(Arrays.asList(1, 12, 13, 14, 15, 16));
        Lotto zero = new Lotto(Arrays.asList(11, 12, 13, 14, 15, 16));

        LottoBundle lottoBundle = new LottoBundle(Arrays.asList(six, one, zero));

        // when
        int[] matchCounts = LottoChecker.getMatchCounts(winner, lottoBundle);

        // then
        assertThat(matchCounts).containsSequence(1, 0, 0, 0, 0, 1);
    }

    @Test
    public void LottoBundle의_당첨_결과() {
        // given
        Lotto winner = new Lotto(Arrays.asList(1, 2, 3, 4, 5, 6));
        Lotto first = new Lotto(Arrays.asList(1, 2, 3, 4, 5, 6));
        Lotto second = new Lotto(Arrays.asList(1, 2, 3, 4, 5, 16));
        Lotto fail = new Lotto(Arrays.asList(11, 12, 13, 14, 15, 16));


        LottoBundle lottoBundle = new LottoBundle(Arrays.asList(first, second, fail));

        // when
        LottoResult lottoResult = LottoChecker.getResult(winner, lottoBundle);

        // then
        assertThat(lottoResult.getFirst()).isEqualTo(1);
        assertThat(lottoResult.getSecond()).isEqualTo(1);
        assertThat(lottoResult.getThird()).isEqualTo(0);
        assertThat(lottoResult.getFourth()).isEqualTo(0);
    }
}
