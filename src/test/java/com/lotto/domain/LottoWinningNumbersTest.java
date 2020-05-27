package com.lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class LottoWinningNumbersTest {

    @DisplayName("로또 구매 : 랜던 값 추출 테스트")
    @ParameterizedTest
    @MethodSource("provideWinningLottoNumbers")
    void manipulateInputWinningLottoNumbersTest(final String input, final List<Integer> expected) {
        LottoWinningNumbers lottoWinningNumbers = LottoWinningNumbers.manipulateInputWinningLottoNumbers(input);
        assertEquals(lottoWinningNumbers.getNumbers(), expected);
    }

    private static Stream<Arguments> provideWinningLottoNumbers() {
        return Stream.of(
                Arguments.of("1, 2, 3, 4, 5, 6", Arrays.asList(1, 2, 3, 4, 5, 6)),
                Arguments.of("7, 8, 9, 10, 11, 12", Arrays.asList(7, 8, 9, 10, 11, 12))
        );
    }

    @DisplayName("로또 구매 : 랜던 값 추출 예외 테스트")
    @ParameterizedTest
    @MethodSource("provideInvalidWinningLottoNumbers")
    void manipulateInputWinningLottoNumbersExceptionTest(final String input) {
        assertThatThrownBy(() -> LottoWinningNumbers.manipulateInputWinningLottoNumbers(input))
                .isInstanceOf(IllegalArgumentException.class);
    }

    private static Stream<Arguments> provideInvalidWinningLottoNumbers() {
        return Stream.of(
                Arguments.of("1, 2, 3, 4, 5"),
                Arguments.of("7, 8, 9, 11, 12")
        );
    }
}
