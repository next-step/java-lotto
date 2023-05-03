package stringcalculator.domain;

import domain.Number;
import domain.Operator;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

public class OperatorTest {

    @DisplayName("사칙연산 입력값 예외를 테스트한다.")
    @Test
    public void elseOperator_Input_ThrowException() {
        Character input = '<';
        assertThatIllegalArgumentException()
                    .isThrownBy(() -> Operator.find(input));
    }

    @DisplayName("더하기를 잘 수행할 수 있다.")
    @Test
    public void plus_Operate_SuccessResult() {
        Double num1 = 10d;
        Double num2 = 5d;

        Operator operator = Operator.find('+');
        assertThat(operator.calculate(num1, num2).value()).isEqualTo(15d);
    }

    @DisplayName("뺄셈을 잘 수행할 수 있다.")
    @Test
    public void minus_Operate_SuccessResult() {
        Double num1 = 10d;
        Double num2 = 5d;

        Operator operator = Operator.find('-');
        assertThat(operator.calculate(num1, num2).value()).isEqualTo(5d);
    }

    @DisplayName("곱하기를 잘 수행할 수 있다.")
    @Test
    public void multiply_Operate_SuccessResult() {
        Double num1 = 10d;
        Double num2 = 5d;

        Operator operator = Operator.find('*');
        assertThat(operator.calculate(num1, num2).value()).isEqualTo(50d);
    }

    @DisplayName("나누기를 잘 수행할 수 있다.")
    @Test
    public void divide_Operate_SuccessResult() {
        Double num1 = 10d;
        Double num2 = 5d;

        Operator operator = Operator.find('/');
        assertThat(operator.calculate(num1, num2).value()).isEqualTo(2d);
    }

    @DisplayName("0으로 나누면 예외가 발생한다.")
    @Test
    public void divide_ByZero_ThrowException() {
        Double num1 = 10d;
        Double num2 = 0d;

        Assertions.assertThatThrownBy(() ->
                        Operator.find('/').calculate(num1, num2));
    }

}
