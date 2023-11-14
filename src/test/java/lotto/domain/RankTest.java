package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThat;

class RankTest {

    @ParameterizedTest(name = "[{index}] 맞춘 숫자가 {0}개 보너스 여부가 {1}면, Rank는 {2} 이다")
    @CsvSource({
            "6, false, FIRST",
            "5, true, SECOND",
            "5, false, THIRD",
            "4, false, FOURTH",
            "3, false, FIFTH"})
    void rank_맞춘숫자_결과(int matchCount, boolean isBonus, Rank expected) {
        Rank findRank = Rank.findRank(matchCount, isBonus);

        assertThat(findRank).isEqualTo(expected);
    }

    @ParameterizedTest(name = "[{index}] 맞춘 숫자가 3이하의 숫자({0}개) 보너스 여부가 {1}면, Rank는 {2} 이다")
    @CsvSource({"0, false, NONE", "1, false, NONE", "2, false, NONE",})
    void rank_등수에_없는결과(int matchCount, boolean isBonus, Rank expected) {
        Rank findRank = Rank.findRank(matchCount, isBonus);

        assertThat(findRank).isEqualTo(expected);
    }

    @ParameterizedTest
    @CsvSource({"FIRST, true", "SECOND, true", "THIRD, true", "FOURTH, true", "NONE, false"})
    @DisplayName("1등 ~ 4등까지는 당첨 등수임을 반환하고 NONE의 경우 당첨이 아님을 반환한다.")
    void isWinningRank(Rank rank, boolean expected) {
        assertThat(rank.isWinningRank()).isEqualTo(expected);
    }
}