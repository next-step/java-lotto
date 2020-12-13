package com.jaenyeong.mission02.lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertEquals;

@DisplayName("Lotto 복권의 한 게임에 해당하는 LotteryGame 클래스 테스트")
class LotteryGameTest {

    @Test
    @DisplayName("LotteryGame 객체 자동 생성 테스트")
    void createLotteryGameAutomatically() {
        final LotteryGame game = LotteryGame.ofAuto();

        final List<Integer> lottery = game.getLotteryNumbers();

        final int max = 6;
        final int start = 1;
        final int end = 45;

        assertEquals(lottery.size(), max);

        lottery.forEach((lotteryNumber) ->
            assertThat(lotteryNumber).isBetween(start, end));
    }

    @ParameterizedTest
    @MethodSource("givenValidNumberList")
    @DisplayName("사용자가 직접 올바른 번호를 지정하는 경우 LotteryGame 객체 생성 테스트")
    void createLotteryGameManuallyWhenGivenValidNumbers(final List<Integer> givenNumbers) {
        final LotteryGame game = LotteryGame.ofManual(givenNumbers);

        final List<Integer> lottery = game.getLotteryNumbers();
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
    @DisplayName("사용자가 직접 올바르지 않은 번호를 지정하는 경우 LotteryGame 객체 생성 테스트")
    void createLotteryGameManuallyWhenGivenInvalidNumbers(final List<Integer> givenNumbers) {
        assertThatThrownBy(() -> {
            final LotteryGame ticket = LotteryGame.ofManual(givenNumbers);
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

    @ParameterizedTest
    @MethodSource("givenValidNumberList")
    @DisplayName("주어진 게임 번호와 현재 번호를 비교하는 테스트")
    void matchWinningNumber(final List<Integer> givenNumbers) {
        final LotteryGame game = LotteryGame.ofManual(givenNumbers);
        final LotteryGame winningGame = LotteryGame.ofManual(Arrays.asList(1, 2, 3, 4, 5, 6));

        final int missMatch = 0;
        final int allRight = 6;

        assertThat(winningGame.checkWinTheLottery(game)).isBetween(missMatch, allRight);
    }

    @ParameterizedTest
    @ValueSource(ints = {1_000, 2_000, 100_000, 1_000_000})
    @DisplayName("주어진 금액으로 구매 가능한 복권 티켓의 수를 확인하는 테스트")
    void checkNumberAvailableForBuy(final int money) {
        final int numberOfGame = LotteryGame.howManyBuyGame(money);

        assertEquals(numberOfGame, money / LotteryGame.PRICE);
    }
}
