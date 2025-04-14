package step2;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import step2.domain.Rank;

public class RankTest {

    @ParameterizedTest
    @CsvSource({
        "0, NONE, 0",
        "1, NONE, 0",
        "2, NONE, 0",
        "3, FOURTH, 5000",
        "4, THIRD, 50000",
        "5, SECOND, 1500000",
        "6, FIRST, 2000000000"
    })
    @DisplayName("Rank Enum 매칭 테스트")
    void testRankMatching(int matchCount, Rank expectedRank, int expectedPrize) {
        Rank rank = Rank.of(matchCount);
        assertAll(
            () -> assertEquals(expectedRank, rank),
            () -> assertEquals(expectedPrize, rank.getPrize())
        );
    }

}
