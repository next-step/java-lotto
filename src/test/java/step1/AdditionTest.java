package step1;

import static org.assertj.core.api.Assertions.*;

import java.math.BigDecimal;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import step1.domain.Calculator;
import step1.domain.Number;

public class AdditionTest {
    @Test
    @DisplayName("덧셈 연산")
    public void additionTest() {
        String operator = "+";
        Number left = Number.of(1);
        Number right = Number.of(2);
        Calculator calculator = new Calculator();
        Number result = calculator.calculate(left, right, operator);
        assertThat(result.getValue()).isEqualTo(BigDecimal.valueOf(3));
    }
}
