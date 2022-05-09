package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThat;

class RankingTest {

    @DisplayName("3 ~ 6개를 입력하면 일치하는 당첨 순위를 반환한다.")
    @ParameterizedTest
    @CsvSource(value = {"1:0:MISS", "3:0:FIFTH", "3:1:FIFTH", "5:0:THIRD", "5:1:SECOND", "6:0:FIRST", "6:1:FIRST"}, delimiter = ':')
    void findMatchRankingTest(int matchCount, int matchBonus, Ranking ranking) {
        assertThat(Ranking.findMatchRanking(new MatchResult(matchCount, matchBonus)))
                .isEqualTo(ranking);
    }
}