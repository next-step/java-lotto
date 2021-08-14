package step3.lotto;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

class RankTest {


    @ParameterizedTest
    @DisplayName("valueOf() 테스트")
    @MethodSource("param")
    void valueOf(long countOfMatch, boolean matchBonus, Rank expectedRank) {
        Rank actual = Rank.valueOf(countOfMatch, matchBonus);
        assertEquals(expectedRank, actual);
    }

    private static Stream<Arguments> param() {
        return Stream.of(
                Arguments.of(6L, false, Rank.FIRST),
                Arguments.of(5L, true, Rank.SECOND),
                Arguments.of(5L, false, Rank.THIRD),
                Arguments.of(4L, false, Rank.FOURTH),
                Arguments.of(3L, false, Rank.FIFTH),
                Arguments.of(2L, false, Rank.MISS),
                Arguments.of(1L, false, Rank.MISS),
                Arguments.of(0L, false, Rank.MISS)
        );
    }
}