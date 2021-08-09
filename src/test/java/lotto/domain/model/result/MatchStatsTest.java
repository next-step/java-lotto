package lotto.domain.model.result;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

public class MatchStatsTest {

    @ParameterizedTest(name = "{index} {0} is less than 3 = {1}")
    @CsvSource({"2,true", "3,false"})
    void isLessThan(int countOfMatch, boolean expected) {
        MatchStats matchStats = MatchStats.of(countOfMatch, true);
        assertThat(matchStats.isLessThan(3)).isEqualTo(expected);
    }

    @ParameterizedTest(name = "{index} countOfMatch = {0}")
    @ValueSource(ints = {1, 2, 3, 4, 5, 6})
    void countEquals(int countOfMatch) {
        MatchStats matchStats = MatchStats.of(countOfMatch, true);
        assertThat(matchStats.countEquals(countOfMatch)).isTrue();
        assertThat(matchStats.countEquals(99)).isFalse();
    }

    @ParameterizedTest(name = "{index} isMatchBonus = {0}")
    @ValueSource(booleans = {true, false})
    void isMatchBonus(boolean expected) {
        MatchStats matchStats = MatchStats.of(2, expected);
        assertThat(matchStats.isMatchBonus()).isEqualTo(expected);
    }
}
