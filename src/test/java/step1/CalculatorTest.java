package step1;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

class CalculatorTest {

    @Test
    void 덧셈_테스트(){
        Operator operator = (firstNumber, secondNumber) -> firstNumber + secondNumber;
        assertThat(operator.operate(49, 51)).isEqualTo(100);
    }

    @Test
    void 뺄셈_테스트(){
        Operator operator = (firstNumber, secondNumber) -> firstNumber - secondNumber;
        assertThat(operator.operate(49, 51)).isEqualTo(-2);
    }

    @Test
    void 곱셈_테스트(){
        Operator operator = (firstNumber, secondNumber) -> firstNumber * secondNumber;
        assertThat(operator.operate(50, 50)).isEqualTo(2500);
        assertThat(operator.operate(0, 50)).isEqualTo(0);
    }

    @Test
    void 나눗셈_테스트(){
        Operator operator = (firstNumber, secondNumber) -> {

            if(secondNumber == 0){
                throw new IllegalArgumentException("0으로는 나눌 수 없습니다.");
            }

            return firstNumber / secondNumber;
        };
        assertThat(operator.operate(7, 3)).isEqualTo(2);
        assertThatThrownBy(() -> operator.operate(1000, 0))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("0으로는 나눌 수 없습니다.");
    }

}