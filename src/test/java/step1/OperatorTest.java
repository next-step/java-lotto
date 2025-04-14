package step1;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import step1.domain.Calculator;
import step1.domain.Number;

public class OperatorTest {
    @Test
    @DisplayName("연산자가 null인 경우")
    public void nullOperator() {
        String operator = null;
        Number left = Number.of(1);
        Number right = Number.of(2);
        Calculator calculator = new Calculator();
        assertThatThrownBy(
            () -> calculator.calculate(left, right, operator)
        ).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("정의한 연산자가 아닌경우")
    public void undefinedOperator() {
        String operator = "&";
        Number left = Number.of(1);
        Number right = Number.of(2);
        Calculator calculator = new Calculator();
        assertThatThrownBy(
            () -> calculator.calculate(left, right, operator)
        ).isInstanceOf(IllegalArgumentException.class);
    }
}
