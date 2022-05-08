import static org.assertj.core.api.Assertions.assertThat;

import domain.Operand;
import domain.Operator;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class OperatorTest {

    @ParameterizedTest
    @DisplayName("+, -, *, / 는 연산자 이다.")
    @ValueSource(strings = {"+", "-", "*", "/"})
    void isOperator(String operator){
        assertThat(Operator.isOperator(operator)).isTrue();
    }

    @Test
    @DisplayName("+ 연산이 가능하다.")
    void plusCalculate(){
        Operator operator = new Operator("+");
        Operand calculate = operator.calculate(new Operand(1), new Operand(2));
        assertThat(calculate).isEqualTo(3);
    }

    @Test
    @DisplayName("- 연산이 가능하다.")
    void minusCalculate(){
        Operator operator = new Operator("-");
        Operand calculate = operator.calculate(new Operand(3), new Operand(2));
        assertThat(calculate).isEqualTo(1);
    }

    @Test
    @DisplayName("* 연산이 가능하다.")
    void multipleCalculate(){
        Operator operator = new Operator("*");
        Operand calculate = operator.calculate(new Operand(3), new Operand(2));
        assertThat(calculate).isEqualTo(6);
    }

    @Test
    @DisplayName("/ 연산이 가능하다.")
    void divideCalculate(){
        Operator operator = new Operator("/");
        Operand calculate = operator.calculate(new Operand(4), new Operand(2));
        assertThat(calculate).isEqualTo(2);
    }

}