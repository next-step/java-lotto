package com.lotto.helper;

import com.lotto.domain.LottoWinningNumbers;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class LottoViewHelperTest {

    @DisplayName("금액 입력 후 개수 테스트")
    @ParameterizedTest
    @MethodSource("provideMoney")
    void getCountOfLottoTest(final Integer money, final Integer expected) {
        Integer result = LottoViewHelper.getCountOfLotto(money);
        assertEquals(result, expected);
    }

    private static Stream<Arguments> provideMoney() {
        return Stream.of(
                Arguments.of(14000, 14),
                Arguments.of(7500, 7),
                Arguments.of(1234, 1)
        );
    }

    @DisplayName("입력 받은 값을 ',' 로 split 해서 List 객체로 만드는 테스트")
    @ParameterizedTest
    @MethodSource("provideLottoNumbers")
    void manipulateInputLottoNumbersTest(final String input, final List<Integer> expected) {
        List<Integer> converted = LottoViewHelper.manipulateInputLottoNumbers(input);
        assertEquals(converted, expected);
    }

    private static Stream<Arguments> provideLottoNumbers() {
        return Stream.of(
                Arguments.of("1, 2, 3, 4, 5, 6", Arrays.asList(1, 2, 3, 4, 5, 6)),
                Arguments.of("7, 8, 9, 10, 11, 12", Arrays.asList(7, 8, 9, 10, 11, 12))
        );
    }

    @DisplayName("입력 받은 값을 ',' 로 split 해서 List 객체로 만드는 예외 테스트")
    @ParameterizedTest
    @MethodSource("provideInvalidLottoNumbers")
    void manipulateInputWinningLottoNumbersExceptionTest(final String input) {
        assertThatThrownBy(() -> LottoViewHelper.manipulateInputLottoNumbers(input))
                .isInstanceOf(IllegalArgumentException.class);
    }

    private static Stream<Arguments> provideInvalidLottoNumbers() {
        return Stream.of(
                Arguments.of("1, 2, 3, 4, 5, 6, 7"),
                Arguments.of("7, 8, 9, 11")
        );
    }
}
