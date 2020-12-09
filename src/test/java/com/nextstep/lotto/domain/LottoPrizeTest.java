package com.nextstep.lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

class LottoPrizeTest {
    @DisplayName("Rank 컬렉션을 인자로 받아 객체를 생성할 수 있다.")
    @Test
    void createTest() {
        List<Rank> ranks = Arrays.asList(Rank.FIRST, Rank.SECOND, Rank.FIRST);

        LottoPrize lottoPrize = new LottoPrize(ranks);

        assertThat(lottoPrize).isEqualTo(new LottoPrize(ranks));
    }

    @DisplayName("수익률을 계산할 수 있다.")
    @ParameterizedTest
    @MethodSource("calculateProfitRateTestResource")
    void calculateProfitRateTest(List<Rank> ranks, Double expectedProfitRate) {
        Money money = new Money(40000L);
        LottoPrize lottoPrize = new LottoPrize(ranks);

        assertThat(lottoPrize.calculateProfitRate(money)).isEqualTo(expectedProfitRate);
    }
    public static Stream<Arguments> calculateProfitRateTestResource() {
        return Stream.of(
                Arguments.of(
                        Arrays.asList(Rank.FIRST, Rank.SECOND, Rank.FIRST),
                        100037.5
                ),
                Arguments.of(
                        Arrays.asList(Rank.FOURTH, Rank.FOURTH),
                        0.25
                )
        );
    }
}
