package step3;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import step3.domain.Rank;

public class RankTest {

    @ParameterizedTest
    @CsvSource({
        "0, MISS, 0, false",
        "1, MISS, 0, false",
        "2, MISS, 0, false",
        "3, FIFTH, 5000, false",
        "4, FOURTH, 50000, false",
        "5, THIRD, 1500000, false",
        "5, SECOND, 30_000_000, true",
        "6, FIRST, 2000000000, false"
    })
    @DisplayName("Rank Enum 매칭 테스트")
    void testRankMatching(int matchCount, Rank expectedRank, int expectedPrize, boolean isBonusMatched) {
        Rank rank = Rank.of(matchCount, isBonusMatched);
        assertAll(
            () -> assertEquals(expectedRank, rank),
            () -> assertEquals(expectedPrize, rank.prize())
        );
    }

}
