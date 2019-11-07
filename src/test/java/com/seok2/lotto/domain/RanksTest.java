package com.seok2.lotto.domain;

import static com.seok2.lotto.domain.Rank.FIRST;
import static com.seok2.lotto.domain.Rank.MISS;
import static com.seok2.lotto.domain.Rank.SECOND;
import static com.seok2.lotto.domain.Rank.THIRD;
import static org.assertj.core.api.Assertions.assertThat;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.stream.Stream;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

class RanksTest {

    static Stream<Arguments> calculateReturnOnInvestmentRate() {
        return Stream.of(
            Arguments.of(Ranks.of(Arrays.asList(MISS, MISS)), ReturnOnInvestmentRate.of(BigDecimal.ZERO)),
            Arguments.of(Ranks.of(Arrays.asList(FIRST)), ReturnOnInvestmentRate.of(2_000_000))
        );
    }

    static Stream<Arguments> count() {
        return Stream.of(
            Arguments.of(FIRST, 1),
            Arguments.of(SECOND, 1),
            Arguments.of(THIRD, 0),
            Arguments.of(MISS, 2)
        );
    }

    @ParameterizedTest
    @MethodSource("count")
    void count(Rank rank, int expected) {
        Ranks ranks = Ranks.of(Arrays.asList(FIRST, SECOND, MISS, MISS));
        assertThat(ranks.count(rank)).isEqualTo(expected);
    }

    @ParameterizedTest
    @MethodSource("calculateReturnOnInvestmentRate")
    void calculateReturnOnInvestmentRate(Ranks ranks, ReturnOnInvestmentRate expected) {
        assertThat(ranks.calculateReturnOnInvestmentRate()).isEqualTo(expected);
    }
}