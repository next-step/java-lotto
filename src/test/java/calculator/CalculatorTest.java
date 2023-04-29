package calculator;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class CalculatorTest {

    @DisplayName("더하기")
    @Test
    public void sum() {
        int a = 5;
        int b = 3;
        int expected = 8;
        assertThat(Operator.ADD.apply(a, b)).isEqualTo(expected);
    }

    @DisplayName("빼기")
    @Test
    public void minus() {
        int a = 9;
        int b = 4;
        int expected = 5;
        assertThat(Operator.SUBTRACT.apply(a, b)).isEqualTo(expected);
    }

    @DisplayName("곱하기")
    @Test
    public void multiple() {
        int a = 4;
        int b = 4;
        int expected = 16;
        assertThat(Operator.MULTIPLY.apply(a, b)).isEqualTo(expected);
    }

    @DisplayName("나누기")
    @Test
    public void divide() {
        int a = 10;
        int b = 2;
        int expected = 5;
        assertThat(Operator.DIVIDE.apply(a, b)).isEqualTo(expected);
    }
}
