package lotto.domain;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

class MatchTest {

    @ParameterizedTest
//    @CsvSource(value = {"1,false,NONE", "2,false,NONE", "3,false,THREE", "4,false,FOUR", "5,false,FIVE",
//            "5,true,FIVE_BONUS", "6,false,SIX"})
    @MethodSource("matchParamsAndMatches")
    public void getMatch(int matchCount, boolean hasBonusNumber, Match match) {
        assertThat(Match.of(matchCount, hasBonusNumber))
                .isEqualTo(match);
    }

    private static Stream<Arguments> matchParamsAndMatches() {
        return Stream.of(
                Arguments.arguments(1, false, Match.NONE),
                Arguments.arguments(2, false, Match.NONE),
                Arguments.arguments(3, false, Match.THREE),
                Arguments.arguments(4, false, Match.FOUR),
                Arguments.arguments(5, false, Match.FIVE),
                Arguments.arguments(5, true, Match.FIVE_BONUS),
                Arguments.arguments(6, false, Match.SIX),
                Arguments.arguments(6, true, Match.SIX)
        );
    }
}
