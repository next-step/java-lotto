package calculator;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

class CalculatorTest {

    @Test
    @DisplayName("덧셈_테스트")
    void add_test() {
        Operator operator = () -> ((firstNumber, secondNumber) -> firstNumber + secondNumber);
        assertThat(operator.operate().applyAsInt(49, 51)).isEqualTo(100);
    }

    @Test
    @DisplayName("뺄셈_테스트")
    void substract_test() {
        Operator operator = () -> ((firstNumber, secondNumber) -> firstNumber - secondNumber);
        assertThat(operator.operate().applyAsInt(49, 51)).isEqualTo(-2);
    }

    @Test
    @DisplayName("곱셈_테스트")
    void multiply_test() {
        Operator operator = () -> ((firstNumber, secondNumber) -> firstNumber * secondNumber);
        assertThat(operator.operate().applyAsInt(50, 50)).isEqualTo(2500);
        assertThat(operator.operate().applyAsInt(0, 50)).isEqualTo(0);
    }

    @Test
    @DisplayName("나눗셈_테스트")
    void divide_test() {
        Operator operator = () -> ((firstNumber, secondNumber) -> {
            if (secondNumber == 0) {
                throw new IllegalArgumentException("0으로는 나눌 수 없습니다.");
            }
            return firstNumber / secondNumber;
        });

        assertThat(operator.operate().applyAsInt(7, 3)).isEqualTo(2);
        assertThatThrownBy(() -> operator.operate().applyAsInt(1000, 0))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("0으로는 나눌 수 없습니다.");
    }

}