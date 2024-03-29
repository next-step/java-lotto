package lottogame.domain;

import static lottogame.domain.Rank.findRank;
import static org.assertj.core.api.Assertions.assertThat;

import java.util.stream.Stream;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

class RankTest {

    @ParameterizedTest
    @MethodSource("countAndRank")
    void 당첨확인(int count, boolean matchBonus, Rank rank) {
        assertThat(findRank(count, matchBonus)).isEqualTo(rank);
    }

    static Stream<Arguments> countAndRank() {
        return Stream.of(
                Arguments.arguments(6, false, Rank.FIRST),
                Arguments.arguments(5, true, Rank.SECOND),
                Arguments.arguments(5, false, Rank.THIRD),
                Arguments.arguments(4, false, Rank.FOURTH),
                Arguments.arguments(3, false, Rank.FIFTH),
                Arguments.arguments(2, false, Rank.EMPTY),
                Arguments.arguments(1, false, Rank.EMPTY),
                Arguments.arguments(0, false, Rank.EMPTY)
        );
    }
}