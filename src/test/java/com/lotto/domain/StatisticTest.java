package com.lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

import static org.assertj.core.api.BDDAssertions.then;

class StatisticTest {

    private static Stream<Arguments> provideCalculateTotalWinningsArguments() {
        return Stream.of(
                Arguments.of(Rank.FIRST, new Rank[] {Rank.FIRST, Rank.SECOND}, new BigDecimal(2_000_000_000)),
                Arguments.of(Rank.FIRST, new Rank[] {Rank.FIRST, Rank.FIRST}, new BigDecimal("4000000000")),
                Arguments.of(Rank.LOSER, new Rank[] {Rank.LOSER}, BigDecimal.ZERO)
        );
    }

    @ParameterizedTest
    @MethodSource("provideCalculateTotalWinningsArguments")
    @DisplayName("통계 결과로 부터 당첨금을 계산하는 메소드 검증")
    void calculateTotalWinnings(Rank rank, Rank[] ranks, BigDecimal expected) {
        List<Rank> _ranks = Arrays.asList(ranks);
        Statistic statistic = new Statistic(rank, _ranks);
        then(statistic.calculateTotalWinnings()).isEqualTo(expected);
    }
}
