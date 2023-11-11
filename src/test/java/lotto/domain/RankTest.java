package lotto.domain;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

class RankTest {

    @ParameterizedTest(name = "[{index}] 맞춘 숫자가 {0}개면, Rank는 {1}")
    @CsvSource({"6, FIRST", "5, SECOND", "4, THIRD", "3, FOURTH"})
    void rank_맞춘숫자_결과(int matchCount, Rank expected) {
        Rank findRank = Rank.findRank(matchCount);

        assertThat(findRank).isEqualTo(expected);
    }

    @Test
    @DisplayName("없는 등수에 대해 찾을 경우 오류가 발생한다.")
    void rank_없는_등수() {
        assertThatIllegalArgumentException()
                .isThrownBy(() -> Rank.findRank(1))
                .withMessage("해당 하는 등수가 존재하지 않습니다.");
    }

    @ParameterizedTest
    @CsvSource({"FIRST, 1", "SECOND, 1", "THIRD, 1", "FOURTH, 1"})
    @DisplayName("각 등수의 배열에 해당하는 등수가 얼마나 포함되어 있는지 결과로 반환한다.")
    void countRankType(Rank rank, int expected) {
        List<Rank> ranks = List.of(Rank.FIRST, Rank.SECOND, Rank.THIRD, Rank.FOURTH);

        assertThat(Rank.countRankType(ranks, rank)).isEqualTo(expected);
    }

    @Test
    @DisplayName("등수 검색을 위해 최소 당첨숫자 정보를 제공한다.(3)")
    void getMinMatchCount() {
        assertThat(Rank.getMinMatchCount()).isEqualTo(3);
    }
}