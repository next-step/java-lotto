package stringcalculator.model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class OperatorTest {

    @DisplayName("생성자는 입력이 유효하지 않으면, 예외를 반환한다.")
    @Test
    void 생성자_예외_테스트() {
        assertThatThrownBy(() -> Operator.of("a"))
                .isInstanceOf(RuntimeException.class);
    }

    @Test
    void 덧셈() {
        Number n1 = new Number(1);
        Number n2 = new Number(2);
        Operator op = Operator.of("+");

        Number expected = op.calculate(n1, n2);

        assertThat(expected.getNumber()).isEqualTo(3);
    }

    @Test
    void 뺄셈() {
        Number n1 = new Number(7);
        Number n2 = new Number(2);
        Operator op = Operator.of("-");

        Number expected = op.calculate(n1, n2);

        assertThat(expected.getNumber()).isEqualTo(5);
    }

    @Test
    void 곱셈() {
        Number n1 = new Number(7);
        Number n2 = new Number(2);
        Operator op = Operator.of("*");

        Number expected = op.calculate(n1, n2);

        assertThat(expected.getNumber()).isEqualTo(14);
    }

    @Test
    void 나눗셈() {
        Number n1 = new Number(7);
        Number n2 = new Number(2);
        Operator op = Operator.of("/");

        Number expected = op.calculate(n1, n2);

        assertThat(expected.getNumber()).isEqualTo(3);
    }

    @DisplayName("나눗셈은 0 으로 나눌 경우, 예외를 반환한다.")
    @Test
    void 나눗셈_예외_테스트() {
        Number n1 = new Number(7);
        Number n2 = new Number(0);
        Operator op = Operator.of("/");

        assertThatThrownBy(() -> op.calculate(n1, n2))
                .isInstanceOf(RuntimeException.class);
    }
}
