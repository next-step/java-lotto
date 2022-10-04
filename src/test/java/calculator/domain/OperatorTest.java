package calculator.domain;

import calculator.domain.Operator;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

/**
 * Created by seungwoo.song on 2022-09-27
 */
class OperatorTest {

    @Test
    void 더하기() {
        assertThat(Operator.PLUS.operate(new CalculateResult(0), new InputValue("1"))).isEqualTo(new CalculateResult(1));
    }

    @Test
    void 빼기() {
        assertThat(Operator.MINUS.operate(new CalculateResult(2), new InputValue("1"))).isEqualTo(new CalculateResult(1));
    }

    @Test
    void 곱하기() {
        assertThat(Operator.MULTIPLE.operate(new CalculateResult(2), new InputValue("2"))).isEqualTo(new CalculateResult(4));
    }

    @Test
    void 나누기() {
        assertThat(Operator.DIVIDE.operate(new CalculateResult(4), new InputValue("2"))).isEqualTo(new CalculateResult(2));
    }

    @Test
    void 나누기_떨어지지않는수() {
        assertThatIllegalArgumentException().isThrownBy(() -> Operator.DIVIDE.operate(new CalculateResult(5), new InputValue("2")));
    }

    @Test
    void 나누기_0() {
        assertThatIllegalArgumentException().isThrownBy(() -> Operator.DIVIDE.operate(new CalculateResult(5), new InputValue("0")));
    }

    @Test
    void 연산자_판단() {
        assertThat(Operator.isOperator("+")).isTrue();
        assertThat(Operator.isOperator("a")).isFalse();
    }

    @Test
    void 연산자_변환() {
        assertThat(Operator.from("+")).isEqualTo(Operator.PLUS);
    }
}