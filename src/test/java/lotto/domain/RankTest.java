package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class RankTest {

    @ParameterizedTest(name = "[{index}] 맞춘 숫자가 {0}개면, Rank는 {1}")
    @CsvSource({"6, FIRST", "5, SECOND", "4, THIRD", "3, FOURTH"})
    void rank_맞춘숫자_결과(int matchCount, Rank expected) {
        Rank findRank = Rank.findRank(matchCount);

        assertThat(findRank).isEqualTo(expected);
    }

    @ParameterizedTest
    @CsvSource({"FIRST, 1", "SECOND, 1", "THIRD, 1", "FOURTH, 1"})
    @DisplayName("각 등수의 배열에 해당하는 등수가 얼마나 포함되어 있는지 결과로 반환한다.")
    void countRankType(Rank rank, int expected) {
        List<Rank> ranks = List.of(Rank.FIRST, Rank.SECOND, Rank.THIRD, Rank.FOURTH);

        assertThat(Rank.countRankType(ranks, rank)).isEqualTo(expected);
    }

    @ParameterizedTest
    @CsvSource({"FIRST, true", "SECOND, true", "THIRD, true", "FOURTH, true", "NONE, false"})
    @DisplayName("1등 ~ 4등까지는 당첨 등수임을 반환하고 NONE의 경우 당첨이 아님을 반환한다.")
    void isWinningRank(Rank rank, boolean expected) {
        assertThat(rank.isWinningRank()).isEqualTo(expected);
    }
}