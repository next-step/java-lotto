package calculator;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

class OperatorTest {

    @DisplayName("Operator는 + - * / 연산을 지원한다")
    @ParameterizedTest
    @CsvSource(value = {"+:PLUS", "-:MINUS", "*:MULTIPLY", "/:DIVIDE"}, delimiter = ':')
    void test1(String symbol, String value){
        Operator.find(symbol)
                .equals(Operator.valueOf(value));
    }

    @DisplayName("Operator는 + - * / 연산만 지원한다")
    @ParameterizedTest
    @ValueSource(strings = {"&", "%", "^"})
    void test2(String symbol){
        Assertions.assertThatThrownBy(() -> Operator.find(symbol)).isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("+ 연산 기능")
    @Test
    void test3(){
        int operand1 = 5;
        int operand2 = 10;
        int expected = 15;

        Assertions.assertThat(Operator.PLUS.calculate(operand1, operand2)).isEqualTo(expected);
    }

    @DisplayName("- 연산 기능")
    @Test
    void test4(){
        int operand1 = 5;
        int operand2 = 10;
        int expected = -5;

        Assertions.assertThat(Operator.MINUS.calculate(operand1, operand2)).isEqualTo(expected);
    }

    @DisplayName("* 연산 기능")
    @Test
    void test5(){
        int operand1 = 5;
        int operand2 = 10;
        int expected = 50;

        Assertions.assertThat(Operator.MULTIPLY.calculate(operand1, operand2)).isEqualTo(expected);
    }

    @DisplayName("/ 연산 기능")
    @Test
    void test6(){
        int operand1 = 10;
        int operand2 = 5;
        int expected = 2;

        Assertions.assertThat(Operator.DIVIDE.calculate(operand1, operand2)).isEqualTo(expected);
    }

    @DisplayName("/ 연산 나누어 떨어지지 않는 경우는 예외처리")
    @ParameterizedTest
    @CsvSource(value = {"7:4", "11:12"}, delimiter = ':')
    void test7(int op1, int op2){
        Assertions.assertThatThrownBy(() -> Operator.DIVIDE.calculate(op1, op2)).isInstanceOf(IllegalArgumentException.class);
    }
}