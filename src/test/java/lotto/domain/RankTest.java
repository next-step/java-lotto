package lotto.domain;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

class RankTest {

    private static Stream<Arguments> rank() {
        return Stream.of(
                Arguments.arguments(Rank.FIRST, 6, 2_000_000_000),
                Arguments.arguments(Rank.SECOND, 5, 1_500_000),
                Arguments.arguments(Rank.THIRD, 4, 50_000),
                Arguments.arguments(Rank.FOURTH, 3, 5000),
                Arguments.arguments(Rank.NONE, 2, 0),
                Arguments.arguments(Rank.NONE, 1, 0),
                Arguments.arguments(Rank.NONE, 0, 0)
        );
    }

    @ParameterizedTest
    @MethodSource("rank")
    void 맞춘_갯수에_따른_등수를_가져온다(Rank rank, int hits, int prize) {
        Rank ranking = Rank.of(hits);

        assertThat(ranking).isEqualTo(rank);
    }

    @ParameterizedTest
    @MethodSource("rank")
    void 맞춘_갯수에_따른_상금을_가져온다(Rank rank, int hits, int prize) {
        Rank ranking = Rank.of(hits);

        assertThat(ranking.wins()).isEqualTo(prize);
    }
}

