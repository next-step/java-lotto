package stringcalculator.domain;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class OperandNumberTest {

    @ValueSource(ints = {1, 2, 3, 4, 5})
    @ParameterizedTest
    @DisplayName("피연산자는 양수인 정수여야 한다.")
    void testValidOperands(int number) {
        assertDoesNotThrow(() -> new OperandNumber(number));
    }

    @ValueSource(strings = {"1", "2", "3", "4", "5"})
    @ParameterizedTest
    @DisplayName("양의 정수로 변환될 수 있는 문자열도 피연산자가 될 수 있다.")
    void testValidStringOperands(String stringNumber) {
        assertDoesNotThrow(() -> new OperandNumber(stringNumber));
    }

    @ValueSource(ints = {-1, -2, -3, -4, -5})
    @ParameterizedTest
    @DisplayName("음수인 수는 예외를 발생시킨다.")
    void testInValidStringOperands(int number) {
        assertThatThrownBy(() -> new OperandNumber(number))
            .isInstanceOf(IllegalArgumentException.class);
    }

    @ValueSource(strings = {"-1", ";", "-100", "d", " "})
    @ParameterizedTest
    @DisplayName("양수로 반환될 수 없는 문자들은 예외를 발생시킨다.")
    void testInValidOperands(String string) {
        assertThatThrownBy(() -> new OperandNumber(string))
            .isInstanceOf(IllegalArgumentException.class);
    }
}
