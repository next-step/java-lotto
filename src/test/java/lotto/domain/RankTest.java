package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThat;

class RankTest {

    @ParameterizedTest(name = "[{index}] 맞춘 숫자가 {0}개면, Rank는 {1}")
    @CsvSource({"6, FIRST", "5, SECOND", "4, THIRD", "3, FOURTH"})
    void rank_맞춘숫자_결과(int matchCount, Rank expected) {
        Rank findRank = Rank.findRank(matchCount);

        assertThat(findRank).isEqualTo(expected);
    }

    @ParameterizedTest
    @CsvSource({"FIRST, true", "SECOND, true", "THIRD, true", "FOURTH, true", "NONE, false"})
    @DisplayName("1등 ~ 4등까지는 당첨 등수임을 반환하고 NONE의 경우 당첨이 아님을 반환한다.")
    void isWinningRank(Rank rank, boolean expected) {
        assertThat(rank.isWinningRank()).isEqualTo(expected);
    }
}