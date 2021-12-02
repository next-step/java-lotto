package edu.nextstep.camp.lotto.domain;

import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.stream.Stream;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.NullSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

public class GameResultTest {
    static Stream<Arguments> parseRanksArguments() {
        return Stream.of(
                Arguments.of(List.of(), Collections.emptyMap()),
                Arguments.of(List.of(Rank.valueOf(6, false)), Map.of(Rank.FIRST, 1L)),
                Arguments.of(List.of(Rank.valueOf(3, false)), Map.of(Rank.FIFTH, 1L)),
                Arguments.of(List.of(Rank.valueOf(3, false), Rank.valueOf(3, false)), Map.of(Rank.FIFTH, 2L))
        );
    }

    @ParameterizedTest(name = "create: {arguments}")
    @MethodSource("parseRanksArguments")
    public void create(List<Rank> input, Map<Rank, Long> expected) {
        assertThat(GameResult.of(input)).isEqualTo(GameResult.of(input));
        assertThat(GameResult.of(input).collect()).containsAllEntriesOf(expected);
    }

    @ParameterizedTest(name = "create failed: {arguments}")
    @NullSource
    public void createFailed(Collection<Rank> ranks) {
        assertThatIllegalArgumentException()
                .isThrownBy(() -> GameResult.of(ranks))
                .withMessageContaining("invalid input");
    }

    @ParameterizedTest(name = "collect: {arguments}")
    @MethodSource("parseRanksArguments")
    public void collect(List<Rank> input, Map<Rank, Long> expected) {
        assertThat(GameResult.of(input).collect()).containsAllEntriesOf(expected);
    }

    @Test
    public void sortedCollect() {
        List<Rank> input = List.of(Rank.THIRD, Rank.FIRST, Rank.FOURTH, Rank.THIRD, Rank.SECOND, Rank.SECOND, Rank.THIRD);
        List<Long> expected = List.of(1L, 2L, 3L, 1L);
        assertThat(GameResult.of(input).collect().values()).containsExactlyElementsOf(expected);
    }

    @ParameterizedTest(name = "size: {arguments}")
    @MethodSource("parseRanksArguments")
    public void size(List<Rank> input, Map<Rank, Long> expected) {
        assertThat(GameResult.of(input).size()).isEqualTo(expected.values().stream().reduce(Long::sum).orElse(0L));
    }

    static Stream<Arguments> parseTotalPrize() {
        return Stream.of(
                Arguments.of(List.of(Rank.FIRST, Rank.FIRST), 4000000000L),
                Arguments.of(List.of(Rank.FIRST), 2000000000L),
                Arguments.of(List.of(Rank.SECOND), 3000000L),
                Arguments.of(List.of(Rank.THIRD), 1500000L),
                Arguments.of(List.of(Rank.FOURTH), 50000L),
                Arguments.of(List.of(Rank.FIFTH), 5000L),
                Arguments.of(List.of(Rank.NO_RANK), 0L)
        );
    }

    @ParameterizedTest(name = "total prize: {arguments}")
    @MethodSource("parseTotalPrize")
    public void totalPrize(List<Rank> ranks, long expected) {
        assertThat(GameResult.of(ranks).totalPrize()).isEqualTo(Prize.of(expected));
    }

    static Stream<Arguments> parsePriceEarningRate() {
        return Stream.of(
                Arguments.of(List.of(Rank.FIRST, Rank.FIRST), 2000000),
                Arguments.of(List.of(Rank.FIRST), 2000000),
                Arguments.of(List.of(Rank.SECOND), 3000),
                Arguments.of(List.of(Rank.THIRD), 1500),
                Arguments.of(List.of(Rank.FOURTH), 50),
                Arguments.of(List.of(Rank.FIFTH), 5),
                Arguments.of(List.of(Rank.NO_RANK), 0)
        );
    }

    @ParameterizedTest(name = "price-earning rate: {0} -> {1}")
    @MethodSource("parsePriceEarningRate")
    public void priceEarningRate(List<Rank> ranks, float expected) {
        assertThat(GameResult.of(ranks).priceEarningRate()).isEqualTo(expected);
    }
}
