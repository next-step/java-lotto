package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class RankingTest {

    @DisplayName("3 ~ 6개를 입력하면 일치하는 당첨 순위를 반환한다.")
    @ParameterizedTest
    @CsvSource(value = {"3:FOURTH", "4:THIRD", "5:SECOND", "6:FIRST"}, delimiter = ':')
    void findMatchRankingTest(int matchCount, Ranking ranking) {
        assertThat(Ranking.findMatchRanking(matchCount))
                .isEqualTo(ranking);
    }

    @DisplayName("당첨 개수가 아닌 숫자를 입력하면 예외를 반환한다.")
    @ParameterizedTest
    @ValueSource(ints = {-1, 0, 2, 7})
    void findMatchRankingTestFail(int matchCount) {
        assertThatThrownBy(() -> Ranking.findMatchRanking(matchCount))
                .isInstanceOf(IllegalArgumentException.class);
    }
}