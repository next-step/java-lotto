package calculator.model;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

public class CalculatorTest {

    @Test
    public void 덧셈() {
        Assertions.assertThat(Calculator.calculateOnce(1,2,Operator.ADD))
                .isEqualTo(3);
        Assertions.assertThat(Calculator.calculateOnce(0,0,Operator.ADD))
                .isEqualTo(0);
    }

    @Test
    public void 뺄셈() {
        Assertions.assertThat(Calculator.calculateOnce(5,3,Operator.SUB))
                .isEqualTo(2);
        Assertions.assertThat(Calculator.calculateOnce(3,5,Operator.SUB))
                .isEqualTo(-2);
    }

    @Test
    public void 곱셈() {
        Assertions.assertThat(Calculator.calculateOnce(2,3,Operator.MUL))
                .isEqualTo(6);
        Assertions.assertThat(Calculator.calculateOnce(-2,3,Operator.MUL))
                .isEqualTo(-6);
        Assertions.assertThat(Calculator.calculateOnce(2,0,Operator.MUL))
                .isEqualTo(0);
    }

    @Test
    public void 나눗셈() {
        Assertions.assertThat(Calculator.calculateOnce(4,2,Operator.DIV))
                .isEqualTo(2);
        Assertions.assertThat(Calculator.calculateOnce(-2,1,Operator.DIV))
                .isEqualTo(-2);
    }
}
