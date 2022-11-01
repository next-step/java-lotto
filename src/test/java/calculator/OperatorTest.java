package calculator;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.*;

class OperatorTest {

    @Test
    void exception() {
        assertThatThrownBy(() -> Operator.operate(1, "&",2))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("지원하지 않는 연산자입니다.");
    }
    @Test
    void add() {
        assertThat(Operator.operate(1, "+",2)).isEqualTo(3);
    }
    @Test
    void sub() {
        assertThat(Operator.operate(1, "-",2)).isEqualTo(-1);
    }
    @Test
    void mul() {
        assertThat(Operator.operate(3, "*",2)).isEqualTo(6);
    }
    @Test
    void div() {
        assertThat(Operator.operate(9, "/",2)).isEqualTo(4);
    }
}