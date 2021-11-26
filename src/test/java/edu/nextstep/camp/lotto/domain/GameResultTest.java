package edu.nextstep.camp.lotto.domain;

import java.util.List;
import java.util.stream.Stream;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.NullSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

public class GameResultTest {
    static Stream<Arguments> parseCreateByRanks() {
        return Stream.of(
                Arguments.of(Ranks.of(List.of(Rank.FIRST)), 1, 0, 0, 0),
                Arguments.of(Ranks.of(List.of(Rank.SECOND)), 0, 1, 0, 0),
                Arguments.of(Ranks.of(List.of(Rank.THIRD)), 0, 0, 1, 0),
                Arguments.of(Ranks.of(List.of(Rank.FOURTH)), 0, 0, 0, 1),
                Arguments.of(Ranks.of(List.of(Rank.NO_RANK)), 0, 0, 0, 0)
        );
    }

    @ParameterizedTest(name = "create: {arguments}")
    @MethodSource("parseCreateByRanks")
    public void create(Ranks ranks, int first, int second, int third, int fourth) {
        assertThat(GameResult.of(ranks))
                .isEqualTo(GameResult.of(ranks));
        assertThat(GameResult.of(ranks).amountOfPlace(Rank.FIRST)).isEqualTo(first);
        assertThat(GameResult.of(ranks).amountOfPlace(Rank.SECOND)).isEqualTo(second);
        assertThat(GameResult.of(ranks).amountOfPlace(Rank.THIRD)).isEqualTo(third);
        assertThat(GameResult.of(ranks).amountOfPlace(Rank.FOURTH)).isEqualTo(fourth);
    }

    @ParameterizedTest
    @NullSource
    public void createByRanksFailed(Ranks ranks) {
        assertThatIllegalArgumentException()
                .isThrownBy(() -> GameResult.of(ranks))
                .withMessageContaining("cannot be null");
    }

    static Stream<Arguments> parseTotalPrize() {
        return Stream.of(
                Arguments.of(Ranks.of(List.of(Rank.FIRST, Rank.FIRST)), 4000000000L),
                Arguments.of(Ranks.of(List.of(Rank.FIRST)), 2000000000L),
                Arguments.of(Ranks.of(List.of(Rank.SECOND)), 1500000L),
                Arguments.of(Ranks.of(List.of(Rank.THIRD)), 50000L),
                Arguments.of(Ranks.of(List.of(Rank.FOURTH)), 5000L),
                Arguments.of(Ranks.of(List.of(Rank.NO_RANK)), 0L)
        );
    }

    @ParameterizedTest(name = "total prize: {arguments}")
    @MethodSource("parseTotalPrize")
    public void totalPrize(Ranks ranks, long expected) {
        assertThat(GameResult.of(ranks).totalPrize()).isEqualTo(Prize.of(expected));
    }
}
