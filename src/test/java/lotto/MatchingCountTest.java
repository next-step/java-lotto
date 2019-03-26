package lotto;

import lotto.domain.MatchingCount;
import lotto.domain.Ranking;
import org.junit.Test;

import static org.assertj.core.api.Java6Assertions.assertThat;

public class MatchingCountTest {
    MatchingCount matchingCount = MatchingCount.FIRST;

    @Test
    public void MatchingCount_반환값_테스트() {
        assertThat(matchingCount.getRank(6)).isEqualTo(Ranking.FIRST_CLASS);
    }

    @Test
    public void 숫자로_넣은_후_값_반환_테스트() {
        MatchingCount matchingCount = MatchingCount.valueOf(6);

        assertThat(matchingCount.getRank(6)).isEqualTo(Ranking.FIRST_CLASS);
    }
}
