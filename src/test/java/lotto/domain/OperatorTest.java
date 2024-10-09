package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class OperatorTest {
    @Test
    @DisplayName("plus enum 연산을 테스트합니다.")
    void testPlusOperation() {
        int result = Operator.PLUS.calculate(10, 5);
        assertThat(result).isEqualTo(15);
    }

    @Test
    @DisplayName("minus enum 연산을 테스트합니다.")
    public void testMinusOperation() {
        int result = Operator.MINUS.calculate(10, 5);
        assertThat(result).isEqualTo(5);
    }

    @Test
    @DisplayName("multiply enum 연산을 테스트합니다.")
    public void testMultiplyOperation() {
        int result = Operator.MULTIPLY.calculate(10, 5);
        assertThat(result).isEqualTo(50);
    }

    @Test
    @DisplayName("divide enum 연산을 테스트합니다.")
    public void testDivideOperation() {
        int result = Operator.DIVIDE.calculate(10, 5);
        assertThat(result).isEqualTo(2);
    }

    @Test
    @DisplayName("divide enum 연산 시 0으로 나누어지면 ArithmeticException 을 던져줍니다.")
    public void testDivideByZero() {
        assertThatThrownBy(() -> Operator.DIVIDE.calculate(10, 0)).isInstanceOf(ArithmeticException.class);
    }
}
