package domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThat;

class RankTest {

    @ParameterizedTest
    @CsvSource(value = {
            "6=true=FIRST",
            "5=true=SECOND",
            "5=false=THIRD",
            "4=true=FORTH",
            "3=true=FIFTH",
            "2=true=MISS"}, delimiter = '=')
    @DisplayName("맞은 숫자에 따라 적합한 당첨순위를 반환한다")
    void getRankTest(int countOfMatch, boolean bonus, String expectedStr) {
        Rank rank = Rank.valueOf(countOfMatch, bonus);
        Rank expected = Rank.valueOf(expectedStr);
        assertThat(rank).isEqualTo(expected);
    }
}