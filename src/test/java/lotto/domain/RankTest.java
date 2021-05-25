package lotto.domain;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

class RankTest {

    @ParameterizedTest
    @MethodSource("provideSourceToValueOf")
    void valueOf_번호_일치_갯수별_결과(int matchCount, Rank expectedResult) {
        // When
        Rank actualResult = Rank.valueOf(matchCount);

        // Then
        assertEquals(expectedResult, actualResult);
    }

    static Stream<Arguments> provideSourceToValueOf() {
        return Stream.of(
                Arguments.of(6, Rank.FIRST),
                Arguments.of(5, Rank.SECOND),
                Arguments.of(4, Rank.THIRD),
                Arguments.of(3, Rank.FOURTH),
                Arguments.of(2, Rank.MISS),
                Arguments.of(1, Rank.MISS),
                Arguments.of(0, Rank.MISS)
        );
    }
}