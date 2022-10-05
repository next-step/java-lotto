package calculator.domain;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

/**
 * Created by seungwoo.song on 2022-10-05
 */
class OperatorTest {

    @Test
    void 더하기() {
        Assertions.assertThat(Operator.PLUS.operate(0, 1)).isEqualTo(1);
    }

    @Test
    void 빼기() {
        assertThat(Operator.MINUS.operate(10, 1)).isEqualTo(9);
    }

    @Test
    void 곱하기() {
        assertThat(Operator.MULTIPLE.operate(10, 5)).isEqualTo(50);
    }

    @Test
    void 나누기() {
        assertThat(Operator.DIVIDE.operate(10, 5)).isEqualTo(2);
    }

    @Test
    void 나누기_0() {
        assertThatThrownBy(() -> Operator.DIVIDE.operate(10, 0))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 나누기_안떨어지는수() {
        assertThatThrownBy(() -> Operator.DIVIDE.operate(10, 3))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 연산자판단() {
        assertThat(Operator.isOperator("+")).isTrue();
        assertThat(Operator.isOperator("1")).isFalse();
    }

    @Test
    void 연산자_변환() {
        assertThat(Operator.from("-")).isEqualTo(Operator.MINUS);
        assertThatThrownBy(() -> Operator.from("d"))
                .isInstanceOf(IllegalArgumentException.class);
    }
}