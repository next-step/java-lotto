package com.jaenyeong.mission02.lotto.domain.lottery;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

@DisplayName("Lotto 게임의 각 복권 번호에 해당하는 LotteryNumber 클래스 테스트")
class LotteryNumberTest {

    @ParameterizedTest
    @ValueSource(ints = {1, 4, 12, 27, 33, 43, 21, 38, 2, 16, 19, 39, 41, 45})
    @DisplayName("유효한 숫자가 주어진 경우 복권 번호 객체의 생성을 확인하는 테스트")
    void createLotteryNumberWhenGivenValidNumber(final int givenNumber) {
        final LotteryNumber lotteryNumber = LotteryNumber.ofManual(givenNumber);

        final int start = 1;
        final int end = 45;

        assertThat(lotteryNumber.getLotteryNumber()).isBetween(start, end);
    }

    @ParameterizedTest
    @ValueSource(ints = {-1, 46, 100, -55})
    @DisplayName("유효하지 않은 숫자가 주어진 경우 복권 번호 객체의 생성을 확인하는 테스트")
    void createLotteryNumberWhenGivenInvalidNumber(final int givenNumber) {
        assertThatThrownBy(() -> {
            final LotteryNumber lotteryNumber = LotteryNumber.ofManual(givenNumber);
        })
            .isInstanceOf(IllegalArgumentException.class)
            .hasMessage("[error] This number is not valid.");
    }
}
