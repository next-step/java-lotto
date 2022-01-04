package lotto.domain;

import static org.junit.jupiter.api.Assertions.*;

import java.util.stream.Stream;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

class MatchTypeTest {

    @ParameterizedTest
    @MethodSource("matchCount")
    @DisplayName("매치 카운트에 맞는 매치타입을 리턴한다.")
    void find_match_type_with_count(int count, boolean matchBonusBall, MatchType matchType) {
        //given

        //when
        MatchType type = MatchType.of(count, matchBonusBall);

        //then
        assertEquals(matchType, type);
    }


    private static Stream<Arguments> matchCount() {
        return Stream.of(
            Arguments.of(3, false, MatchType.THREE),
            Arguments.of(4, true, MatchType.FOUR),
            Arguments.of(5, false, MatchType.FIVE),
            Arguments.of(5, true, MatchType.FIVE_AND_BONUS_BALL),
            Arguments.of(6, false, MatchType.SIX)
        );
    }

}