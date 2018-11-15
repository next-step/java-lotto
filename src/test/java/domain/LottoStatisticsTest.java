package domain;

import org.junit.Before;
import org.junit.Test;

import java.util.Collections;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class LottoStatisticsTest {

    private LottoStatistics lottoStatistics;

    @Before
    public void setup() {
        String winningNumbers = "1, 2, 3, 4, 5, 6";
        WinningLotto winningLotto = new WinningLotto(winningNumbers, 17);
        lottoStatistics = new LottoStatistics(winningLotto);
    }

    @Test
    public void 당첨통계_0개일치_확인() {
        List<Lotto> lottoNumbers = Collections.singletonList(Lotto.manual("8, 10, 20, 30, 40, 45"));
        int matchCount = lottoStatistics.match(lottoNumbers).matchCount(Rank.MISS);
        assertThat(matchCount).isEqualTo(1);
    }

    @Test
    public void 당첨통계_3개일치_확인() {
        List<Lotto> lottoNumbers = Collections.singletonList(Lotto.manual("1, 2, 3, 23, 35, 37"));
        int matchCount = lottoStatistics.match(lottoNumbers).matchCount(Rank.FIFTH);
        assertThat(matchCount).isEqualTo(1);
    }

    @Test
    public void 당첨통계_4개일치_확인() {
        List<Lotto> lottoNumbers = Collections.singletonList(Lotto.manual("1, 2, 3, 4, 35, 37"));
        int matchCount = lottoStatistics.match(lottoNumbers).matchCount(Rank.FOURTH);
        assertThat(matchCount).isEqualTo(1);
    }

    @Test
    public void 당첨통계_5개일치_확인() {
        List<Lotto> lottoNumbers = Collections.singletonList(Lotto.manual("1, 2, 3, 4, 5, 42"));
        int matchCount = lottoStatistics.match(lottoNumbers).matchCount(Rank.THIRD);
        assertThat(matchCount).isEqualTo(1);
    }

    @Test
    public void 당첨통계_6개일치_확인() {
        List<Lotto> lottoNumbers = Collections.singletonList(Lotto.manual("1, 2, 3, 4, 5, 6"));
        int matchCount = lottoStatistics.match(lottoNumbers).matchCount(Rank.FIRST);
        assertThat(matchCount).isEqualTo(1);
    }
}
