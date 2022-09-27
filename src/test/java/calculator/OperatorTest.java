package calculator;

import calculator.domain.Operator;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Created by seungwoo.song on 2022-09-27
 */
class OperatorTest {

    @Test
    void 더하기() {
        assertThat(Operator.PLUS.operate(0, 1)).isEqualTo(1);
    }

    @Test
    void 빼기() {
        assertThat(Operator.MINUS.operate(2, 1)).isEqualTo(1);
    }

    @Test
    void 곱하기() {
        assertThat(Operator.MULTIPLE.operate(2, 2)).isEqualTo(4);
    }

    @Test
    void 나누기() {
        assertThat(Operator.DIVIDE.operate(5, 2)).isEqualTo(2);
    }

    @Test
    void 연산자_판단() {
        assertThat(Operator.isOperator("+")).isTrue();
        assertThat(Operator.isOperator("a")).isFalse();
    }

    @Test
    void 연산자_변환() {
        assertThat(Operator.parse("+")).isEqualTo(Operator.PLUS);
    }
}