package lotto;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

import lotto.domain.MatchResult;
import lotto.domain.Rank;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class RankTest {
    @Test
    @DisplayName("6개 일치이면 1등이다")
    void firstRank() {
        assertThat(Rank.of(new MatchResult(6, false))).isEqualTo(Rank.FIRST);
    }

    @Test
    @DisplayName("5개 일치 + 보너스 일치이면 2등이다")
    void secondRank() {
        assertThat(Rank.of(new MatchResult(5, true))).isEqualTo(Rank.SECOND);
    }

    @Test
    @DisplayName("5개 일치 + 보너스 불일치이면 3등이다")
    void thirdRank() {
        assertThat(Rank.of(new MatchResult(5, false))).isEqualTo(Rank.THIRD);
    }

    @Test
    @DisplayName("4개 일치이면 4등이다")
    void fourthRank() {
        assertThat(Rank.of(new MatchResult(4, false))).isEqualTo(Rank.FOURTH);
    }

    @Test
    @DisplayName("3개 일치이면 5등이다")
    void fifthRank() {
        assertThat(Rank.of(new MatchResult(3, false))).isEqualTo(Rank.FIFTH);
    }

    @Test
    @DisplayName("2개 이하 일치이면 MISS이다")
    void missRank() {
        assertThat(Rank.of(new MatchResult(2, false))).isEqualTo(Rank.MISS);
    }
}
