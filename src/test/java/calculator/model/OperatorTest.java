package calculator.model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

class OperatorTest {
    @Test
    @DisplayName("덧셈 연산을 수행한다.")
    public void plusTest() {
        Operator plus = new Operator("+");
        assertThat(plus.calculate(new Number(2), new Number(3))).isEqualTo(new Number(5));
    }

    @Test
    @DisplayName("뺄셈 연산을 수행한다.")
    public void minusTest() {
        assertThat(new Operator("-").calculate(new Number(5), new Number(2))).isEqualTo(new Number(3));
    }

    @Test
    @DisplayName("곱셈 연산을 수행한다.")
    public void multiplyTest() {
        assertThat(new Operator("*").calculate(new Number(4), new Number(3)))
                .isEqualTo(new Number(12));
    }

    @Test
    @DisplayName("나눗셈 연산을 수행한다.")
    public void divideTest() {
        assertThat(new Operator("/").calculate(new Number(10), new Number(2)))
                .isEqualTo(new Number(5));
    }

    @Test
    @DisplayName("나눠 떨어지지 않는 경우는 오류가 발생한다.")
    public void divideResultIsIntegerTest() {
        assertThatIllegalArgumentException().isThrownBy(() -> {
            new Operator("/").calculate(new Number(3), new Number(2));
        });
    }

    @Test
    @DisplayName("지원하지 않는 연산자가 들어오면 오류가 발생한다.")
    public void wrongOperatorTest() {
        assertThatIllegalArgumentException().isThrownBy(() -> {
            new Operator("%");
        });
    }
}