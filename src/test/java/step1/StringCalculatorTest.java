package step1;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.catchThrowable;

class StringCalculatorTest {
    @DisplayName("null이 입려된 경우 IllegalArgumentException이 발생해야 함")
    @Test()
    void nullInput() {
        StringCalculator stringCalculator = new StringCalculator();
        Throwable thrown = catchThrowable(() -> stringCalculator.runOperation(null));
        assertThat(thrown).isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("빈문자열이 입려된 경우 IllegalArgumentException이 발생해야 함")
    @Test()
    void emptyInput() {
        StringCalculator stringCalculator = new StringCalculator();
        Throwable thrown = catchThrowable(() -> stringCalculator.runOperation(""));
        assertThat(thrown).isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("정수범위를 벗어난 값이 입려된 경우 NumberFormatException이 발생해야 함")
    @Test()
    void overMaxIntegerInput() {
        StringCalculator stringCalculator = new StringCalculator();
        Throwable thrown = catchThrowable(() -> stringCalculator.runOperation("2147483648"));
        assertThat(thrown).isInstanceOf(NumberFormatException.class);
    }

    @DisplayName("입력값이 하나인경우 입력값 그대로 반환해야 함")
    @ParameterizedTest(name = "{index} {displayName} parameter=\"{0}\"")
    @CsvSource(value = { "0:0", "-1:-1", "1:1", "-2147483647:-2147483647", "2147483647:2147483647" }, delimiter = ':')
    void singleInput(String input, String expected) {
        StringCalculator stringCalculator = new StringCalculator();
        int result = stringCalculator.runOperation(input);
        assertThat(result).isEqualTo(Integer.parseInt(expected));
    }

    @DisplayName("2개이상의 입력숫자 연산시 정상 처리 되어야 함")
    @ParameterizedTest(name = "{index} {displayName} parameter=\"{0}\"")
    @CsvSource(value = { "1 + 5:6", "5 - 10:-5", "3 * 2:6", "5 / 2:2", "3 + 10 - 2 / 7 * 2:2" }, delimiter = ':')
    void twoInput(String input, String expected) {
        StringCalculator stringCalculator = new StringCalculator();
        int result = stringCalculator.runOperation(input);
        assertThat(result).isEqualTo(Integer.parseInt(expected));
    }
}