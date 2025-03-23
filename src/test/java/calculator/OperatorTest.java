package calculator;

import calculator.domain.Operator;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

class OperatorTest {
    @Test
    @DisplayName("지원하지 않는 연산자를 입력하는 경우 IllegalArgumentException 이 발생한다.")
    public void enter_unsupportedOperator_throwsIllegalArgumentException() {
        assertThatIllegalArgumentException()
                .isThrownBy(() -> Operator.getOperatorBySymbol("&"));
    }

    @Test
    @DisplayName("덧셈")
    public void plus() {
        int actual = Operator.PLUS.calculate(1, 2);
        int expected = 3;
        assertThat(actual).isEqualTo(expected);
    }

    @Test
    @DisplayName("뺄셈")
    public void minus() {
        int actual = Operator.MINUS.calculate(5, 2);
        int expected = 3;
        assertThat(actual).isEqualTo(expected);
    }

    @Test
    @DisplayName("곱셈")
    public void multiply() {
        int actual = Operator.MULTIPLY.calculate(3, 3);
        int expected = 9;
        assertThat(actual).isEqualTo(expected);
    }

    @Test
    @DisplayName("나눗셈")
    public void divide() {
        int actual = Operator.DIVIDE.calculate(8, 4);
        int expected = 2;
        assertThat(actual).isEqualTo(expected);
    }

}