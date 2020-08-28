package com.lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.math.BigDecimal;
import java.util.stream.Stream;

import static org.assertj.core.api.BDDAssertions.then;

class RankTest {

    private static Stream<Arguments> provideMatchRankArguments() {
        return Stream.of(
                Arguments.of(6, Rank.FIRST),
                Arguments.of(5, Rank.SECOND),
                Arguments.of(4, Rank.THIRD),
                Arguments.of(3, Rank.FORTH),
                Arguments.of(2, Rank.LOSER),
                Arguments.of(1, Rank.LOSER),
                Arguments.of(0, Rank.LOSER)
        );
    }

    @ParameterizedTest
    @MethodSource("provideMatchRankArguments")
    @DisplayName("일치하는 복권 숫자로 등수를 반환하는 메소드 검증")
    void matchRank(int matchingCount, Rank expected) {
        then(Rank.matchRank(matchingCount)).isEqualTo(expected);
    }

    private static Stream<Arguments> provideCalculateTotalWinningsArguments() {
        return Stream.of(
                Arguments.of(Rank.FIRST, 1, new BigDecimal(2_000_000_000)),
                Arguments.of(Rank.FIRST, 2, new BigDecimal("4000000000")),
                Arguments.of(Rank.LOSER, 1, BigDecimal.ZERO)
        );
    }

    @ParameterizedTest
    @MethodSource("provideCalculateTotalWinningsArguments")
    @DisplayName("일치하는 복권 숫자로 등수를 반환하는 메소드 검증")
    void calculateTotalWinnings(Rank rank, int lotteryCount, BigDecimal expected) {
        then(rank.calculateTotalWinnings(lotteryCount)).isEqualTo(expected);
    }
}
