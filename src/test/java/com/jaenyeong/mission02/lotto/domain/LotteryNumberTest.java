package com.jaenyeong.mission02.lotto.domain;

import com.jaenyeong.mission02.lotto.domain.LotteryNumber;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertFalse;

@DisplayName("Lotto 게임의 각 복권 번호에 해당하는 LotteryNumber 클래스 테스트")
class LotteryNumberTest {

    @ParameterizedTest
    @MethodSource("existsValidLottoNumberList")
    @DisplayName("LottoNumber 객체 생성 테스트")
    void createLotteryNumber(final List<Integer> existsNumbers) {
        final LotteryNumber lotteryNumber = LotteryNumber.of(existsNumbers);

        final int start = 1;
        final int end = 45;

        assertThat(lotteryNumber.getLotteryNumber()).isBetween(start, end);
        assertFalse(existsNumbers.contains(lotteryNumber.getLotteryNumber()));
    }

    private static Stream<Arguments> existsValidLottoNumberList() {
        return Stream.of(
            Arguments.of(Arrays.asList(1, 2, 3, 4)),
            Arguments.of(Arrays.asList()),
            Arguments.of(Arrays.asList(18, 17, 20, 45)),
            Arguments.of(Arrays.asList(0, 2, 4, 6, 8, 10))
        );
    }

    @ParameterizedTest
    @MethodSource("existsInvalidLottoNumberList")
    @DisplayName("1부터 45의 숫자를 모두 넘겨 LottoNumber 객체 생성시 실패하는 테스트")
    void createLotteryNumberWhenGivenAllNumbers(final List<Integer> existsNumbers) {
        assertThatThrownBy(() -> {
            final LotteryNumber lotteryNumber = LotteryNumber.of(existsNumbers);
        })
            .isInstanceOf(IllegalArgumentException.class)
            .hasMessage("[error] There is no number to choose from list.");
    }

    private static Stream<Arguments> existsInvalidLottoNumberList() {
        return Stream.of(
            Arguments.of(Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10,
                11, 12, 13, 14, 15, 16, 17, 18, 19, 20,
                21, 22, 23, 24, 25, 26, 27, 28, 29, 30,
                31, 32, 33, 34, 35, 36, 37, 38, 39, 40,
                41, 42, 43, 44, 45))
        );
    }
}
