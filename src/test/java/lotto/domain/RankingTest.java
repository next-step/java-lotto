package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThat;

class RankingTest {

    @DisplayName("3 ~ 6개를 입력하면 일치하는 당첨 순위를 반환한다.")
    @ParameterizedTest
    @CsvSource(value = {"1:false:MISS", "3:false:FIFTH", "3:true:FIFTH", "5:false:THIRD", "5:true:SECOND", "6:false:FIRST", "6:true:FIRST"}, delimiter = ':')
    void findMatchRankingTest(int matchCount, boolean matchBonus, Ranking ranking) {
        assertThat(Ranking.findMatchRanking(matchCount, matchBonus))
                .isEqualTo(ranking);
    }
}