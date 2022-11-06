package lotto.numbers;

import static org.assertj.core.api.Assertions.*;

import java.util.List;
import java.util.stream.Stream;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import lotto.numbers.WinningNumbers;

public class WinningNumbersTest {
    @ParameterizedTest
    @MethodSource("winningNumbersSuccessParam")
    public void getNumbers(String inputNumbers) {
        List<Integer> numbers = WinningNumbers.getNumbers(inputNumbers);
    }

    @ParameterizedTest
    @MethodSource("winningNumbersFailedParam")
    public void getNumbersFailed(String inputNumbers, String errorMessage) {
        assertThatThrownBy(() -> {
            List<Integer> numbers = WinningNumbers.getNumbers(inputNumbers);
        }).isInstanceOf(RuntimeException.class).hasMessage(errorMessage);
    }

    public static Stream<Arguments> winningNumbersSuccessParam() {
        return Stream.of(
          Arguments.of("1, 2, 3, 4, 5, 6"),
          Arguments.of("12,14,17,27,35,44"),
          Arguments.of("6,9,11,18,26,39"),
          Arguments.of("33,34,35,36,37,38"),
          Arguments.of("39, 40, 41, 42, 43, 44")
        );
    }

    public static Stream<Arguments> winningNumbersFailedParam() {
        return Stream.of(
                Arguments.of("a, b, c, d, e, f", "올바르지 않은 당첨번호 형식입니다."),
                Arguments.of("1, 2, 3, 4, 5", "당첨번호는 6자리여야 합니다."),
                Arguments.of("  ", "당첨 번호를 입력해주세요."),
                Arguments.of("0, 1, 2, 3, 4, 5", "당첨번호의 범위는 1~45 범위의 숫자여야 합니다."),
                Arguments.of("43, 44, 45, 46, 47, 48", "당첨번호의 범위는 1~45 범위의 숫자여야 합니다.")
        );
    }
}
