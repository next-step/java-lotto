package calculator.validate;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.InputMismatchException;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class InputValidatorTest {

    @ParameterizedTest
    @DisplayName("계산식 내 구분자 포함 여부")
    @CsvSource(
            delimiter = ':',
            value = {"10 + 5:true", "10+5:false"}
    )
    void containSeparator() {
        assertThat(InputValidator.containSeparator("10 + 5")).isTrue();
    }

    @Test
    @DisplayName("계산식의 피연산자 검증")
    void isValidOperand() {
        assertThat(InputValidator.isValidOperand("10 + 5")).isTrue();
    }

    @Test
    @DisplayName("계산식의 피연산자 예외 검증")
    void isValidOperandException() {
        assertThatThrownBy(() -> InputValidator.isValidOperand("a + b"))
                .isInstanceOf(InputMismatchException.class);
    }

    @Test
    @DisplayName("계산식의 연산자 검증")
    void isValidOperator() {
        assertThat(InputValidator.isValidOperator("10 + 5")).isTrue();
    }

    @Test
    @DisplayName("계산식의 연산자 예외 검증")
    void isValidOperatorException() {
        assertThatThrownBy(() -> InputValidator.isValidOperator("10 a 5"))
                .isInstanceOf(InputMismatchException.class);
    }

    @ParameterizedTest
    @DisplayName("문자열의 피연산자 검증")
    @CsvSource(
            delimiter = ':',
            value = {"5:true", "a:false"}
    )
    void isNumeric(String input, boolean expected) {
        assertThat(InputValidator.isNumeric(input)).isEqualTo(expected);
    }

    @ParameterizedTest
    @DisplayName("문자열의 연산자 검증")
    @CsvSource(
            delimiter = ':',
            value = {"+:true", "a:false"}
    )
    void isOperator(String input, boolean expected) {
        assertThat(InputValidator.isOperator(input)).isEqualTo(expected);
    }
}
