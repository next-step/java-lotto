package calculator;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class OperatorTest {

    @Test
    void add() {
        Operator operator = Operator.from("+");
        assertThat(operator.apply(2, 3)).isEqualTo(5);
    }

    @Test
    void sub() {
        Operator operator = Operator.from("-");
        assertThat(operator.apply(2, 3)).isEqualTo(-1);
    }

    @Test
    void mul() {
        Operator operator = Operator.from("*");
        assertThat(operator.apply(2, 3)).isEqualTo(6);
    }

    @Test
    void div() {
        Operator operator = Operator.from("/");
        assertThat(operator.apply(2, 3)).isEqualTo(0);
    }
}
