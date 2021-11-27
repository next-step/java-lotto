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

public class RanksTest {
    static Stream<Arguments> parseRanksArguments() {
        return Stream.of(
                Arguments.of(List.of(), Collections.emptyMap()),
                Arguments.of(List.of(Rank.valueOf(6)), Map.of(Rank.FIRST, 1)),
                Arguments.of(List.of(Rank.valueOf(3)), Map.of(Rank.FOURTH, 1)),
                Arguments.of(List.of(Rank.valueOf(3), Rank.valueOf(3)), Map.of(Rank.FOURTH, 2))
        );
    }

    @ParameterizedTest(name = "create: {arguments}")
    @MethodSource("parseRanksArguments")
    public void create(List<Rank> input, Map<Rank, Integer> expected) {
        assertThat(Ranks.of(input)).isEqualTo(Ranks.of(input));
        assertThat(Ranks.of(input).collect()).containsAllEntriesOf(expected);
        assertThat(Ranks.of(input).collect()).containsAllEntriesOf(expected);
    }

    @ParameterizedTest(name = "create failed: {arguments}")
    @NullSource
    public void createFailed(Collection<Rank> ranks) {
        assertThatIllegalArgumentException()
                .isThrownBy(() -> Ranks.of(ranks))
                .withMessageContaining("invalid input");
    }

    @ParameterizedTest(name = "collect: {arguments}")
    @MethodSource("parseRanksArguments")
    public void collect(List<Rank> input, Map<Rank, Integer> expected) {
        assertThat(Ranks.of(input).collect()).containsAllEntriesOf(expected);
    }

    @Test
    public void sortedCollect() {
        List<Rank> input = List.of(Rank.THIRD, Rank.FIRST, Rank.FOURTH, Rank.THIRD, Rank.SECOND, Rank.SECOND, Rank.THIRD);
        List<Integer> expected = List.of(1, 2, 3, 1);
        assertThat(Ranks.of(input).collect().values()).containsExactlyElementsOf(expected);
    }

    @ParameterizedTest(name = "size: {arguments}")
    @MethodSource("parseRanksArguments")
    public void size(List<Rank> input, Map<Rank, Integer> expected) {
        assertThat(Ranks.of(input).size()).isEqualTo(expected.values().stream().reduce(Integer::sum).orElse(0));
    }

    static Stream<Arguments> parseEachPlaces() {
        return Stream.of(
                Arguments.of(List.of(Rank.FIRST), 1, 0, 0, 0),
                Arguments.of(List.of(Rank.SECOND), 0, 1, 0, 0),
                Arguments.of(List.of(Rank.THIRD), 0, 0, 1, 0),
                Arguments.of(List.of(Rank.FOURTH), 0, 0, 0, 1),
                Arguments.of(List.of(Rank.NO_RANK), 0, 0, 0, 0),
                Arguments.of(List.of(), 0, 0, 0, 0)
        );
    }

    @ParameterizedTest(name = "amount of each places: {arguments}")
    @MethodSource("parseEachPlaces")
    public void amountOfEachPlaces(List<Rank> ranks, int first, int second, int third, int fourth) {
        assertThat(Ranks.of(ranks).amountOfPlace(Rank.FIRST)).isEqualTo(first);
        assertThat(Ranks.of(ranks).amountOfPlace(Rank.SECOND)).isEqualTo(second);
        assertThat(Ranks.of(ranks).amountOfPlace(Rank.THIRD)).isEqualTo(third);
        assertThat(Ranks.of(ranks).amountOfPlace(Rank.FOURTH)).isEqualTo(fourth);

    }

    static Stream<Arguments> parseTotalPrize() {
        return Stream.of(
                Arguments.of(List.of(Rank.FIRST, Rank.FIRST), 4000000000L),
                Arguments.of(List.of(Rank.FIRST), 2000000000L),
                Arguments.of(List.of(Rank.SECOND), 1500000L),
                Arguments.of(List.of(Rank.THIRD), 50000L),
                Arguments.of(List.of(Rank.FOURTH), 5000L),
                Arguments.of(List.of(Rank.NO_RANK), 0L)
        );
    }

    @ParameterizedTest(name = "total prize: {arguments}")
    @MethodSource("parseTotalPrize")
    public void totalPrize(List<Rank> ranks, long expected) {
        assertThat(Ranks.of(ranks).totalPrize()).isEqualTo(Prize.of(expected));
    }
}
