package calculator;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class OperatorTest {

    @Test
    @DisplayName("입력한 연산자가 나와야 한다")
    void of() {
        Assertions.assertThat(Operator.of("+")).isEqualTo(Operator.PLUS);
        Assertions.assertThat(Operator.of("-")).isEqualTo(Operator.MINUS);
        Assertions.assertThat(Operator.of("*")).isEqualTo(Operator.MULTIPLY);
        Assertions.assertThat(Operator.of("/")).isEqualTo(Operator.DIVIDE);
    }

    @Test
    @DisplayName("operator를 입력하지 않거나 잘못 입력하면 에러가 발생해야 한다")
    void ofFail() {
        Assertions.assertThatThrownBy(() -> Operator.of("")).isInstanceOf(IllegalArgumentException.class);
        Assertions.assertThatThrownBy(() -> Operator.of("++")).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("연산자에 따라 계산이 되어야 한다")
    void calculate() {
        Assertions.assertThat(Operator.PLUS.calculate(1, 2)).isEqualTo(3);
        Assertions.assertThat(Operator.MINUS.calculate(1, 2)).isEqualTo(-1);
        Assertions.assertThat(Operator.MULTIPLY.calculate(1, 2)).isEqualTo(2);
        Assertions.assertThat(Operator.DIVIDE.calculate(4, 2)).isEqualTo(2);
    }

    @Test
    @DisplayName("0으로 나누거나 나누어 떨어지지 않으면 에러가 발생해야 한다")
    void calculateDivideFail() {
        Assertions.assertThatThrownBy(() -> Operator.DIVIDE.calculate(1, 0)).isInstanceOf(IllegalArgumentException.class);
        Assertions.assertThatThrownBy(() -> Operator.DIVIDE.calculate(3, 2)).isInstanceOf(IllegalArgumentException.class);
    }
}
