package calculator.model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class CalculatorTest {
    @Test
    @DisplayName("올바른 계산식을 입력하면 계산 결과를 반환한다.")
    void validExpressionTest() {
        Calculator calculator = new Calculator(
                new Numbers(List.of(new Number(2), new Number(3), new Number(4), new Number(2))),
                new Operators(List.of(new Operator("+"), new Operator("-"), new Operator("*")))
        );
        assertThat(calculator.run()).isEqualTo(new Number(2));
    }
}