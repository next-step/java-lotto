package calculator;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class OperatorTest {
    @DisplayName("+ 연산자 테스트")
    @Test
    public void plus() throws Exception {
        assertThat(Operator.PLUS.calculate(1, 2))
                .isEqualTo(3);
        assertThat(Operator.PLUS.calculate(5, 15))
                .isEqualTo(20);
    }

    @DisplayName("- 연산자 테스트")
    @Test
    public void minus() throws Exception {
        assertThat(Operator.MINUS.calculate(1, 2))
                .isEqualTo(-1);
        assertThat(Operator.MINUS.calculate(5, 15))
                .isEqualTo(-10);
    }

    @DisplayName("* 연산자 테스트")
    @Test
    public void multiply() throws Exception {
        assertThat(Operator.MULTIPLY.calculate(1, 2))
                .isEqualTo(2);
        assertThat(Operator.MULTIPLY.calculate(5, 15))
                .isEqualTo(75);
    }

    @DisplayName("/ 연산자 테스트")
    @Test
    public void divide() throws Exception {
        assertThat(Operator.DIVIDE.calculate(10, 5))
                .isEqualTo(2);
        assertThat(Operator.DIVIDE.calculate(100, 20))
                .isEqualTo(5);
    }
}