package calculator.domain;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class OperatorTest {

    @Test
    void plusTest() {
        Operator operator = Operator.of("+");
        assertThat(operator.calculate(3, 2))
                .isEqualTo(5);
    }

    @Test
    void minusTest() {
        Operator operator = Operator.of("-");
        assertThat(operator.calculate(3, 2))
                .isEqualTo(1);
    }

    @Test
    void multiplyTest() {
        Operator operator = Operator.of("*");
        assertThat(operator.calculate(3, 2))
                .isEqualTo(6);
    }

    @Test
    void divideTest() {
        Operator operator = Operator.of("/");
        assertThat(operator.calculate(6, 2))
                .isEqualTo(3);
    }
}