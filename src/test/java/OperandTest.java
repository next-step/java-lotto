import static org.assertj.core.api.Assertions.assertThat;

import domain.Operand;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class OperandTest {

    @Test
    @DisplayName("피연산자간의 덧셈")
    void plus(){
        Operand operand1 = new Operand(1);
        Operand operand2 = new Operand(2);
        assertThat(operand1.plus(operand2)).isEqualTo(new Operand(3));
    }

    @Test
    @DisplayName("피연산자간의 뺄셈")
    void minus(){
        Operand operand1 = new Operand(2);
        Operand operand2 = new Operand(1);
        assertThat(operand1.minus(operand2)).isEqualTo(new Operand(1));
    }

    @Test
    @DisplayName("피연사자간의 곱셈")
    void multiple(){
        Operand operand1 = new Operand(2);
        Operand operand2 = new Operand(3);
        assertThat(operand1.multiple(operand2)).isEqualTo(new Operand(6));
    }

    @Test
    @DisplayName("피연산자간의 나눗셈")
    void divide(){
        Operand operand1 = new Operand(4);
        Operand operand2 = new Operand(2);
        assertThat(operand1.divide(operand2)).isEqualTo(new Operand(2));
    }

    @Test
    @DisplayName("나눗셈은 정수로 떨어지는 값을 결과값으로 한정한다.")
    void divideResultIsOnlyInteger(){
        Operand operand1 = new Operand(5);
        Operand operand2 = new Operand(2);
        assertThat(operand1.divide(operand2)).isEqualTo(new Operand(2));
    }

    @ParameterizedTest
    @ValueSource(strings = {"1", "10", "238"})
    @DisplayName("문자열이 피연산자인지 확인할 수 있다.")
    void isOperand(String operand){
        assertThat(Operand.isOperand(operand)).isTrue();
    }

    @ParameterizedTest
    @ValueSource(strings = {"*", "+", "-"})
    @DisplayName("문자열이 피연산자가 아닌지 확인할 수 있다.")
    void isNotOperand(String operand){
        assertThat(Operand.isOperand(operand)).isFalse();
    }
}