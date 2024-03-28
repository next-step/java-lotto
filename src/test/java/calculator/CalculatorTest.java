package calculator;

import calculator.domain.Calculator;
import calculator.domain.Operation;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.NullAndEmptySource;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.Arrays;

import static calculator.domain.Calculator.NULL_AND_EMPTY_VALIDATE;
import static calculator.domain.Calculator.OPERATOR_VALIDATE;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class CalculatorTest {

    private static final String PLUS = "+";
    private static final String MULTIPLY = "*";
    private static final String SUBTRACT = "-";
    private static final String DIVIDE = "/";
    private static final String DEFAULT = "2 + 3 * 4 / 3";
    private static final String NOT_OPERATOR = "2 & 3";

    @ParameterizedTest
    @ValueSource(strings = {DEFAULT})
    @DisplayName("스플릿 기본 테스트")
    void spilt_test(String input) {
        String[] seperateString = input.split(" ");
        System.out.println(seperateString.length);
        System.out.println(Arrays.toString(seperateString));
    }

    @DisplayName("산식계산")
    @ParameterizedTest
    @CsvSource({"2 + 3 * 4 / 3, 6"})
    void calculate(String input, int result) {
        assertThat(Calculator.calculator(input)).isEqualTo(result);
    }

    @ParameterizedTest
    @ValueSource(strings = {DEFAULT})
    @DisplayName("혼합된 사칙연산")
    void 복합연산(String input) {
        assertThat(Calculator.calculator(input)).isEqualTo(6);
    }

    @ParameterizedTest
    @NullAndEmptySource
    @DisplayName("공백 혹은 null 입력")
    void null_공백_입력(String input) {
        assertThatThrownBy(() -> Calculator.calculator(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(NULL_AND_EMPTY_VALIDATE);
    }

    @ParameterizedTest
    @ValueSource(strings = {NOT_OPERATOR})
    @DisplayName("사칙연산자 아닌 연산자 입력")
    void 사칙연산자_아님(String input) {
        assertThatThrownBy(() -> Calculator.calculator(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(OPERATOR_VALIDATE);
    }
}
