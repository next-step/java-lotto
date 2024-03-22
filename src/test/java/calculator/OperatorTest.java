package calculator;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class OperatorTest {

    @ParameterizedTest
    @ValueSource(strings = {"+", "-", "*", "/"})
    @DisplayName("입력 받은 연산자에 대한 Operator 찾는다.")
    void getOperator(String operator) {
        //when & then
        assertThat(Operator.getOperator(operator).getDisplay()).isEqualTo(operator);
    }

    @Test
    @DisplayName("입력 받은 두 인자에 대한 합을 구한다.")
    void sumOperator() {
        //given
        Operator plus = Operator.PLUS;
        //when & then
        assertThat(plus.calculate(1,2)).isEqualTo(3);
    }

    @Test
    @DisplayName("입력 받은 두 인자에 대한 뺄셈을 구한다.")
    void minusOperator() {
        //given
        Operator minus = Operator.MINUS;
        //when & then
        assertThat(minus.calculate(1,2)).isEqualTo(-1);
    }

    @Test
    @DisplayName("입력 받은 두 인자에 대한 곱셈을 구한다.")
    void multiplyOperator() {
        //given
        Operator multiply = Operator.MULTIPLY;
        //when & then
        assertThat(multiply.calculate(1,2)).isEqualTo(2);
    }

    @Test
    @DisplayName("입력 받은 두 인자에 대한 나눗셈을 구한다.")
    void divideOperator() {
        //given
        Operator divide = Operator.DIVIDE;
        //when & then
        assertThat(divide.calculate(2,2)).isEqualTo(1);
    }
}
