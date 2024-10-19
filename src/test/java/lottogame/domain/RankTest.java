package lottogame.domain;

import lottogame.domain.lotto.Rank;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

class RankTest {

    @ParameterizedTest
    @MethodSource("provideRankTestCases")
    @DisplayName("일치하는 개수와 보너스 번호 일치 여부에 따라 올바른 Rank를 반환한다")
    void from(int matchCount, boolean matchBonus, Rank expectedRank) {
        assertEquals(expectedRank, Rank.from(matchCount, matchBonus));
    }

    private static Stream<Arguments> provideRankTestCases() {
        return Stream.of(
                Arguments.of(6, false, Rank.FIRST),
                Arguments.of(5, true, Rank.SECOND),
                Arguments.of(4, false, Rank.FOURTH),
                Arguments.of(3, false, Rank.FIFTH),
                Arguments.of(2, false, Rank.NONE),
                Arguments.of(1, false, Rank.NONE),
                Arguments.of(0, false, Rank.NONE)
        );
    }

}
