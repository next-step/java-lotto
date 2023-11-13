import domain.Calculator;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullAndEmptySource;
import org.junit.jupiter.params.provider.ValueSource;
import validator.ArithmeticInputValidator;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class StringCalculatorTest {

    @ParameterizedTest
    @NullAndEmptySource
    @DisplayName("null 또는 공백을 입력하는 경우 오류가 발생한다.")
    void nullAndBlankTest(String input) {
        assertThrows(IllegalArgumentException.class, () -> ArithmeticInputValidator.validateArithmeticInput(input));
    }

    @ParameterizedTest
    @ValueSource(strings = {"?", "%", "@"})
    @DisplayName("+, -, /, * 이외의 기호가 들어오는 경우 오류가 발생한다.")
    void invalidOperatorTest(String input) {
        assertThrows(IllegalArgumentException.class, () -> ArithmeticInputValidator.validateArithmeticInput(input));
    }

    @ParameterizedTest
    @ValueSource(strings = {"1 + 2 + ", "-5 +"})
    @DisplayName("숫자를 하나 덜 입력하는 경우 오류가 발생한다.")
    void InvalidInputWithMissingNumberTest(String input) {
        assertThrows(IllegalArgumentException.class, () -> ArithmeticInputValidator.validateArithmeticInput(input));
    }
    @ParameterizedTest
    @ValueSource(strings = {"-1 + 2 + +", "1 2"})
    @DisplayName("사칙연산이 가능한 형태로 입력하지 않는 경우 오류가 발생한다.")
    void invalidInputTest(String input) {
        assertThrows(IllegalArgumentException.class, () -> ArithmeticInputValidator.validateArithmeticInput(input));
    }

    @Test
    @DisplayName("숫자와 사칙연산 사이에 공백이 없는 경우 Exception을 발생시킨다.")
    void noBlankBetweenNumberAndOperatorTest() {
        String input = "1+2";

        assertThrows(IllegalArgumentException.class, () -> ArithmeticInputValidator.validateArithmeticInput(input));
    }

    @Test
    void addTest() {
        String input = "2 + 3";
        String[] operandAndOperator = ArithmeticInputValidator.validateArithmeticInput(input);

        int result = Calculator.calculateArithmetic(operandAndOperator);

        assertThat(result).isEqualTo(5);
    }

    @Test
    void subtractTest() {
        String input = "2 - 3";
        String[] operandAndOperator = ArithmeticInputValidator.validateArithmeticInput(input);

        int result = Calculator.calculateArithmetic(operandAndOperator);

        assertThat(result).isEqualTo(-1);
    }

    @Test
    void multiplyTest() {
        String input = "2 * 3";
        String[] operandAndOperator = ArithmeticInputValidator.validateArithmeticInput(input);

        int result = Calculator.calculateArithmetic(operandAndOperator);

        assertThat(result).isEqualTo(6);
    }

    @Test
    void divideTest() {
        String input = "2 / 3";
        String[] operandAndOperator = ArithmeticInputValidator.validateArithmeticInput(input);

        int result = Calculator.calculateArithmetic(operandAndOperator);

        assertThat(result).isEqualTo(0);
    }

    @Test
    @DisplayName("나눈셈 분모에 0을 넣는 경우 오류가 발생한다.")
    void wrongDivideTest() {
        String input = "2 / 0";
        String[] operandAndOperator = ArithmeticInputValidator.validateArithmeticInput(input);

        assertThrows(ArithmeticException.class, () -> Calculator.calculateArithmetic(operandAndOperator));
    }

    @Test
    @DisplayName("사칙연산 계산 테스트")
    void arithmeticCalculateTest() {
        String input = "2 + 3 / 2 * 5";
        String[] operandAndOperator = ArithmeticInputValidator.validateArithmeticInput(input);

        int result = Calculator.calculateArithmetic(operandAndOperator);

        assertThat(result).isEqualTo(10);
    }
}
