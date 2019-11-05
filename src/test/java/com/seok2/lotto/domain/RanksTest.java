package com.seok2.lotto.domain;

import static com.seok2.lotto.domain.Rank.*;
import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

import java.util.Arrays;
import java.util.stream.Stream;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

class RanksTest {

    static Stream<Arguments> count() {
        return Stream.of(
            Arguments.of(FIRST, 1),
            Arguments.of(SECOND, 1),
            Arguments.of(THIRD, 0),
            Arguments.of(MISS, 2)
        );
    }

    static Stream<Arguments> getTotalReward() {
        return Stream.of(
            Arguments.of(Ranks.of(Arrays.asList(MISS, MISS)), Money.ZERO),
            Arguments.of(Ranks.of(Arrays.asList(FIRST)), Money.of(2_000_000_000)),
            Arguments.of(Ranks.of(Arrays.asList(FIFTH, FIFTH, MISS)), Money.of(10_000))
        );
    }

    @ParameterizedTest
    @MethodSource("count")
    void count(Rank rank, int expected) {
        Ranks ranks = Ranks.of(Arrays.asList(FIRST, SECOND, MISS, MISS));
        assertThat(ranks.count(rank)).isEqualTo(expected);
    }

    @ParameterizedTest
    @MethodSource("getTotalReward")
    void getTotalReward(Ranks ranks, Money expected) {
        assertThat(ranks.getTotalReward()).isEqualTo(expected);
    }
}