package com.seok2.lotto.domain;

import static com.seok2.lotto.domain.Rank.*;
import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

import java.math.BigDecimal;
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
            Arguments.of(Ranks.of(Arrays.asList(MISS, MISS)), BigDecimal.ZERO),
            Arguments.of(Ranks.of(Arrays.asList(FIRST)), new BigDecimal(2_000_000))
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
    void getTotalReward(Ranks ranks, BigDecimal expected) {
        assertThat(ranks.calculateYield()).isEqualTo(expected);
    }
}