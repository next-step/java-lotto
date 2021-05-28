package lotto.domain;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static lotto.domain.Rank.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

class RankTest {

    @ParameterizedTest
    @MethodSource("provideSourceToValueOf")
    void valueOf_번호_일치_갯수별_결과(int matchCount, int matchBonusCount, Rank expectedResult) {
        // When
        Rank actualResult = Rank.valueOf(matchCount, matchBonusCount);

        // Then
        assertEquals(expectedResult, actualResult);
    }

    static Stream<Arguments> provideSourceToValueOf() {
        return Stream.of(
                Arguments.of(6, 0, FIRST),
                Arguments.of(5, 1, SECOND),
                Arguments.of(5, 0, THIRD),
                Arguments.of(4, 0, FOURTH),
                Arguments.of(3, 0, FIFTH),
                Arguments.of(2, 0, MISS),
                Arguments.of(1, 0, MISS),
                Arguments.of(0, 0, MISS)
        );
    }
}