package calculator.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.NullAndEmptySource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class CalculatorTest {
    @ParameterizedTest
    @NullAndEmptySource
    @DisplayName("null, empty가 입력되면 IllegalArgumentException throw")
    void nullOrEmptyTest(String input) {
        assertThatIllegalArgumentException().isThrownBy(() -> Calculator.calculate(input));
    }

    @ParameterizedTest
    @ValueSource(strings = {"1 : 3", "1 + 3 / 2 $ 5"})
    @DisplayName("사칙 연산이 아닌 값이 포함되면 IllegalArgumentException throw")
    void containsNotOperatorTest(String input) {
        assertThatIllegalArgumentException().isThrownBy(() -> Calculator.calculate(input));
    }

    @ParameterizedTest
    @CsvSource({"1 + 3,4", "1 + 2,3", "1 + 5 + 7,13"})
    @DisplayName("더하기 사칙 연산 테스트")
    void plusOperatorTest(String input, String expected) {
        int result = Calculator.calculate(input);
        assertThat(result).isEqualTo(Integer.parseInt(expected));
    }

    @ParameterizedTest
    @CsvSource({"1 - 3,-2", "1 - 7,-6", "10 - 5 - 2,3"})
    @DisplayName("빼기 사칙 연산 테스트")
    void minusOperatorTest(String input, String expected) {
        int result = Calculator.calculate(input);
        assertThat(result).isEqualTo(Integer.parseInt(expected));
    }

    @ParameterizedTest
    @CsvSource({"1 * 3,3", "7 * 2,14", "10 * 5 * 2,100"})
    @DisplayName("곱하기기 사칙 연산 테스트")
    void multiplyOperatorTest(String input, String expected) {
        int result = Calculator.calculate(input);
        assertThat(result).isEqualTo(Integer.parseInt(expected));
    }

    @ParameterizedTest
    @CsvSource({"1 / 3,0", "7 / 2,3", "9 / 3 / 3,1"})
    @DisplayName("나누기 사칙 연산 테스트")
    void dividerOperatorTest(String input, String expected) {
        int result = Calculator.calculate(input);
        assertThat(result).isEqualTo(Integer.parseInt(expected));
    }

    @Test
    @DisplayName("divide 연산 시 0으로 나누어지면 ArithmeticException 을 던져줍니다.")
    void testDivideByZero() {
        assertThatThrownBy(() -> Calculator.calculate("1 / 0")).isInstanceOf(ArithmeticException.class);
    }


    @ParameterizedTest
    @CsvSource({"2 + 3 * 4 / 2,10", "2 + 3 / 4 + 2,3", "2 * 3 * 4 / 2 - 3,9"})
    @DisplayName("복합 사칙 연산 테스트")
    void combineOperatorsTest(String input, String expected) {
        int result = Calculator.calculate(input);
        assertThat(result).isEqualTo(Integer.parseInt(expected));
    }
}
