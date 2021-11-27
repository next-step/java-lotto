package edu.nextstep.camp.lotto.domain;

import java.util.List;
import java.util.Map;
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
                Arguments.of(Ranks.of(List.of(Rank.FIRST, Rank.FIRST)), Map.of(Rank.FIRST, 2)),
                Arguments.of(Ranks.of(List.of(Rank.FIRST)), Map.of(Rank.FIRST, 1)),
                Arguments.of(Ranks.of(List.of(Rank.SECOND)), Map.of(Rank.SECOND, 1)),
                Arguments.of(Ranks.of(List.of(Rank.THIRD)), Map.of(Rank.THIRD, 1)),
                Arguments.of(Ranks.of(List.of(Rank.FOURTH)), Map.of(Rank.FOURTH, 1)),
                Arguments.of(Ranks.of(List.of(Rank.NO_RANK)), Map.of(Rank.NO_RANK, 1))
        );
    }

    @ParameterizedTest(name = "create: {arguments}")
    @MethodSource("parseCreateByRanks")
    public void create(Ranks ranks, Map<Rank, Integer> expectedRankMap) {
        assertThat(GameResult.of(ranks)).isEqualTo(GameResult.of(ranks));
        assertThat(GameResult.of(ranks).collect()).containsExactlyEntriesOf(expectedRankMap);
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

    static Stream<Arguments> parsePriceEarningRate() {
        return Stream.of(
                Arguments.of(List.of(Rank.FIRST, Rank.FIRST), 2000000),
                Arguments.of(List.of(Rank.FIRST), 2000000),
                Arguments.of(List.of(Rank.SECOND), 1500),
                Arguments.of(List.of(Rank.THIRD), 50),
                Arguments.of(List.of(Rank.FOURTH), 5),
                Arguments.of(List.of(Rank.NO_RANK), 0)
        );
    }

    @ParameterizedTest(name = "price-earning rate: {0} -> {1}")
    @MethodSource("parsePriceEarningRate")
    public void priceEarningRate(List<Rank> ranks, float expected) {
        final GameResult gameResult = GameResult.of(Ranks.of(ranks));
        assertThat(gameResult.priceEarningRate()).isEqualTo(expected);
    }
}
