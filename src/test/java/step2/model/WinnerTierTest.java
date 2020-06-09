package step2.model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

class WinnerTierTest {

    @ParameterizedTest
    @MethodSource("provideArguments")
    @DisplayName("WinnerTire enum 테스트")
    void 랭킹_확인_테스트 (int matchCnt, WinnerTier expected) {
        assertEquals(WinnerTier.valueOf(matchCnt), expected);
    }

    private static Stream<Arguments> provideArguments () {
        return Stream.of(
                Arguments.of(3, WinnerTier.MATCH_THREE),
                Arguments.of(4, WinnerTier.MATCH_FOUR),
                Arguments.of(5, WinnerTier.MATCH_FIVE),
                Arguments.of(6, WinnerTier.MATCH_SIX)
        );
    }

}