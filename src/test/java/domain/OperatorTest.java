package domain;

import domain.symbol.Operand;
import domain.symbol.Operator;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;


class OperatorTest {

    @DisplayName("덧셈 연산 테스트")
    @Test
    void operateAddTest() {
        // Given
        Operand operand1 = new Operand(1);
        Operand operand2 = new Operand(2);

        // When
        Operator operator = new Operator("+");
        Operand result = operator.operate(operand1, operand2);

        // Then
        int expected = 3;
        assertThat(result).isEqualTo(new Operand(expected));
    }

    @DisplayName("뺄셈 연산 테스트")
    @Test
    void operateSubtractTest() {
        // Given
        Operand operand1 = new Operand(1);
        Operand operand2 = new Operand(2);

        // When
        Operator operator = new Operator("-");
        Operand result = operator.operate(operand1, operand2);

        // Then
        int expected = -1;
        assertThat(result).isEqualTo(new Operand(expected));
    }

    @DisplayName("곱셈 연산 테스트")
    @Test
    void operateMultiplyTest() {
        // Given
        Operand operand1 = new Operand(1);
        Operand operand2 = new Operand(2);

        // When
        Operator operator = new Operator("*");
        Operand result = operator.operate(operand1, operand2);

        // Then
        int expected = 2;
        assertThat(result).isEqualTo(new Operand(expected));
    }

    @DisplayName("나눗셈 연산 테스트")
    @CsvSource(value = {"4, 2, 2", "6, 4, 1"})
    @ParameterizedTest
    void operateDivideTest(Integer first, Integer second, Integer expected) {
        // Given
        Operand operand1 = new Operand(first);
        Operand operand2 = new Operand(second);

        // When
        Operator operator = new Operator("/");
        Operand result = operator.operate(operand1, operand2);

        // Then
        assertThat(result).isEqualTo(new Operand(expected));
    }

    @DisplayName("0으로 나누는 경우 예외 발생")
    @Test
    void divideByZeroTest() {
        // Given
        Operand operand1 = new Operand(4);
        Operand operand2 = new Operand(0);

        // When
        Operator operator = new Operator("/");

        // Then
        assertThatThrownBy(() -> operator.operate(operand1, operand2))
                .isInstanceOf(ArithmeticException.class);
    }

    @DisplayName("연산자가 아닌 경우 예외 발생")
    @Test
    void invalidOperatorTest() {
        assertThatThrownBy(() -> new Operator("!"))
                .isInstanceOf(IllegalArgumentException.class);
    }
}