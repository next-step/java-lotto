package com.jaenyeong.mission02.lotto.domain.lottery;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertEquals;

@DisplayName("Lotto 게임에 복권 번호 리스트의 래핑 객체(일급 컬렉션) LotteryNumbers 클래스 테스트")
class LotteryNumbersTest {

    @Test
    @DisplayName("LottoNumbers 객체 자동 생성 테스트")
    void createLotteryNumbersAutomatically() {
        final LotteryNumbers lotteryNumbers = LotteryNumbers.ofAuto();

        final List<Integer> lottery = lotteryNumbers.getLotteryNumbers();

        final int max = 6;
        final int start = 1;
        final int end = 45;

        assertEquals(lottery.size(), max);

        lottery.forEach((lotteryNumber) -> assertThat(lotteryNumber).isBetween(start, end));
    }

    @ParameterizedTest
    @MethodSource("givenValidNumberList")
    @DisplayName("사용자가 직접 올바른 번호를 지정하는 경우 LottoNumbers 객체 생성 테스트")
    void createLotteryNumberManuallyWhenGivenValidNumbers(final List<Integer> givenNumbers) {
        final LotteryNumbers lotteryNumbers = LotteryNumbers.ofManual(givenNumbers);

        final List<Integer> lottery = lotteryNumbers.getLotteryNumbers();
        givenNumbers.sort(Comparator.naturalOrder());

        final int max = 6;
        final int start = 1;
        final int end = 45;

        assertEquals(lottery.size(), max);
        lottery.forEach((lotteryNumber) -> assertThat(lotteryNumber).isBetween(start, end));
        assertEquals(lottery, givenNumbers);
    }

    private static Stream<Arguments> givenValidNumberList() {
        return Stream.of(
            Arguments.of(Arrays.asList(1, 2, 3, 4, 5, 6)),
            Arguments.of(Arrays.asList(8, 17, 26, 33, 41, 45)),
            Arguments.of(Arrays.asList(1, 12, 23, 34, 42, 45)),
            Arguments.of(Arrays.asList(10, 20, 30, 40, 15, 25)),
            Arguments.of(Arrays.asList(40, 41, 42, 43, 44, 45))
        );
    }

    @ParameterizedTest
    @MethodSource("givenInvalidNumberList")
    @DisplayName("사용자가 직접 올바르지 않은 번호를 지정하는 경우 LottoNumbers 객체 생성 테스트")
    void createLotteryNumberManuallyWhenGivenInvalidNumbers(final List<Integer> givenNumbers) {
        assertThatThrownBy(() -> {
            final LotteryNumbers lotteryNumbers = LotteryNumbers.ofManual(givenNumbers);
        })
            .isInstanceOf(IllegalArgumentException.class);
    }

    private static Stream<Arguments> givenInvalidNumberList() {
        return Stream.of(
            Arguments.of(Arrays.asList()),
            Arguments.of(Arrays.asList(-1, 17, 26, 33, 41, 45)),
            Arguments.of(Arrays.asList(1, 12, 23, 34, 42, 46)),
            Arguments.of(Arrays.asList(10, 20, 30, 40, 15)),
            Arguments.of(Arrays.asList(40, 41))
        );
    }
}
