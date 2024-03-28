package caculator;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import caculator.domain.Calculator;

public class CalculatorTest {
    @DisplayName("연산자 타입에 따라 계산이 진행된다 : + ")
    @Test
    void plus_operation(){
        int operand1 = 10;
        int operand2 = 2;
        String plus = "+";

        Calculator sut = new Calculator(0, null);
        sut.calculate(operand1);
        sut.saveOperation(plus);
        int result = sut.calculate(operand2);

        Assertions.assertThat(result).isEqualTo(12);
    }

    @DisplayName("연산자 타입에 따라 계산이 진행된다 : - ")
    @Test
    void minus_operation(){
        int operand1 = 10;
        int operand2 = 2;
        String minus = "-";

        Calculator sut = new Calculator(0, null);
        sut.calculate(operand1);
        sut.saveOperation(minus);
        int result = sut.calculate(operand2);
        Assertions.assertThat(result).isEqualTo(8);
    }

    @DisplayName("연산자 타입에 따라 계산이 진행된다 : / ")
    @Test
    void divide_operation(){
        int operand1 = 10;
        int operand2 = 2;
        String divide = "/";

        Calculator sut = new Calculator(0, null);
        sut.calculate(operand1);
        sut.saveOperation(divide);
        int result = sut.calculate(operand2);
        Assertions.assertThat(result).isEqualTo(5);
    }

    @DisplayName("연산자 타입에 따라 계산이 진행된다 : * ")
    @Test
    void multiple_operation(){

        int operand1 = 10;
        int operand2 = 2;
        String multiple = "*";

        Calculator sut = new Calculator(0, null);
        sut.calculate(operand1);
        sut.saveOperation(multiple);
        int result = sut.calculate(operand2);
        Assertions.assertThat(result).isEqualTo(20);
    }
}
