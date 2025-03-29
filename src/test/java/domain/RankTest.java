package domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThat;

class RankTest {

    @ParameterizedTest
    @DisplayName("일치 개수에 따라 올바른 Rank를 반환한다")
    @CsvSource({"3, false, FIFTH", "4, false, FOURTH", "5, false, THIRD", "5, true, SECOND", "6, false, FIRST"})
    void Rank_매치(int matchCount, boolean isBonusNumberMatched,Rank expectedRank) {
        assertThat(Rank.of(matchCount, isBonusNumberMatched)).isEqualTo(expectedRank);
    }

    @ParameterizedTest
    @DisplayName("Rank 별 상금을 반환한다")
    @CsvSource({"FIFTH, 5000", "FOURTH, 50000", "THIRD, 1500000", "SECOND, 30000000", "FIRST, 2000000000"})
    void 상금_반환(Rank rank, int expectedPrize) {
        assertThat(rank.getPrize()).isEqualTo(expectedPrize);
    }
}