package calculator;

import calculator.domain.Calculator;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullAndEmptySource;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.Arrays;

import static calculator.domain.Calculator.NULL_AND_EMPTY_VALIDATE;
import static calculator.domain.Calculator.OPERATOR_VALIDATE;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class CalculatorTest {

    private static final String DEFAULT = "2 + 3 * 4 / 3";
    private static final String PLUS = "1 + 1";
    private static final String MULTIPLY = "1 * 1";
    private static final String SUBTRACT = "1 - 1";
    private static final String DIVIDE = "1 / 1";
    private static final String NOT_OPERATOR = "2 & 3";

    @ParameterizedTest
    @ValueSource(strings = {DEFAULT})
    void spilt_test(String input) {
        String[] seperateString = input.split(" ");
        System.out.println(seperateString.length);
        System.out.println(Arrays.toString(seperateString));
    }

    @ParameterizedTest
    @ValueSource(strings = {PLUS})
    void 더하기(String input) {
        Calculator calculator = new Calculator();
        assertThat(calculator.calculator(input)).isEqualTo(2);
    }

    @ParameterizedTest
    @ValueSource(strings = {MULTIPLY})
    void 곱하기(String input) {
        Calculator calculator = new Calculator();
        assertThat(calculator.calculator(input)).isEqualTo(1);
    }

    @ParameterizedTest
    @ValueSource(strings = {SUBTRACT})
    void 나누기(String input) {
        Calculator calculator = new Calculator();
        assertThat(calculator.calculator(input)).isEqualTo(1);
    }

    @ParameterizedTest
    @ValueSource(strings = {DIVIDE})
    void 빼기(String input) {
        Calculator calculator = new Calculator();
        assertThat(calculator.calculator(input)).isEqualTo(1);
    }

    @ParameterizedTest
    @ValueSource(strings = {DEFAULT})
    void 복합연산(String input) {
        Calculator calculator = new Calculator();
        assertThat(calculator.calculator(input)).isEqualTo(6);
    }

    @ParameterizedTest
    @NullAndEmptySource
    void null_공백_입력(String input) {
        Calculator calculator = new Calculator();
        assertThatThrownBy(() -> calculator.calculator(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(NULL_AND_EMPTY_VALIDATE);
    }

    @ParameterizedTest
    @ValueSource(strings = {NOT_OPERATOR})
    void 사칙연산자_아님(String input) {
        Calculator calculator = new Calculator();
        assertThatThrownBy(() -> calculator.calculator(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(OPERATOR_VALIDATE);
    }
}
