package domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThat;

class RankTest {

    @ParameterizedTest
    @DisplayName("일치 개수에 따라 올바른 Rank를 반환한다")
    @CsvSource({"3, FOURTH", "4, THIRD", "5, SECOND", "6, FIRST"})
    void Rank_매치(int matchCount, Rank expectedRank) {
        assertThat(Rank.of(matchCount)).isEqualTo(expectedRank);
    }

    @ParameterizedTest
    @DisplayName("Rank 별 상금을 반환한다")
    @CsvSource({"FOURTH, 5000", "THIRD, 50000", "SECOND, 1500000", "FIRST, 2000000000"})
    void 상금_반환(Rank rank, int expectedPrize) {
        assertThat(rank.getPrize()).isEqualTo(expectedPrize);
    }
}