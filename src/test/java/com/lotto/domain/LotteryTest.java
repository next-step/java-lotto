package com.lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.Arrays;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static org.assertj.core.api.BDDAssertions.then;

class LotteryTest {

    private static Stream<Arguments> provideHasLotteryNumberArguments() {
        return Stream.of(
                Arguments.of(new int[]{1, 2, 3, 4, 5, 6}, 1, true),
                Arguments.of(new int[]{1, 2, 3, 4, 5, 6}, 7, false)
        );
    }

    @ParameterizedTest
    @MethodSource("provideHasLotteryNumberArguments")
    @DisplayName("복권에 특정 번호가 있는지 확인하는 메소드 검증")
    void hasLotteryNumber(int[] numbers, int target, boolean expected) {
        Set<LotteryNumber> lotteryNumbers = Arrays.stream(numbers)
                .mapToObj(LotteryNumber::getLotteryNumber)
                .collect(Collectors.toSet());
        Lottery lottery = new Lottery(lotteryNumbers);

        then(lottery.hasLotteryNumber(LotteryNumber.getLotteryNumber(target))).isEqualTo(expected);
    }
}
