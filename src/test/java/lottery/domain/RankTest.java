package lottery.domain;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.stream.Stream;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

class RankTest {

    @ParameterizedTest
    @MethodSource("testArgs")
    void create(int countOfMatch, boolean bonusMatch, Rank expectedRank) {
        assertThat(Rank.valueOf(countOfMatch, bonusMatch)).isEqualTo(expectedRank);
    }

    static Stream<Arguments> testArgs() {
        return Stream.of(
            Arguments.arguments(0, false, Rank.MISS),
            Arguments.arguments(1, false, Rank.MISS),
            Arguments.arguments(2, false, Rank.MISS),
            Arguments.arguments(3, false, Rank.FIFTH),
            Arguments.arguments(4, false, Rank.FOURTH),
            Arguments.arguments(5, false, Rank.THIRD),
            Arguments.arguments(5, true, Rank.SECOND),
            Arguments.arguments(6, false, Rank.FIRST),

            Arguments.arguments(0, true, Rank.MISS),
            Arguments.arguments(1, true, Rank.MISS),
            Arguments.arguments(2, true, Rank.MISS),
            Arguments.arguments(3, true, Rank.FIFTH),
            Arguments.arguments(4, true, Rank.FOURTH),
            Arguments.arguments(5, false, Rank.THIRD),
            Arguments.arguments(5, true, Rank.SECOND),
            Arguments.arguments(6, true, Rank.FIRST)
        );
    }
}
