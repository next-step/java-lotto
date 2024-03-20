package step1_caculator;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import step1_caculator.domain.CalculationExecutor;
import step1_caculator.type.OperatorType;

public class CalculationExecutorTest {
    @DisplayName("연산자 타입에 따라 계산이 진행된다 : + ")
    @Test
    void plus_operation(){
        int operand1 = 10;
        int operand2 = 2;
        OperatorType plusType = OperatorType.PLUS;

        CalculationExecutor sut = new CalculationExecutor();
        sut.calculate(operand1);
        sut.saveOperatorType(plusType);
        sut.calculate(operand2);

        Assertions.assertThat(sut.getResult()).isEqualTo(12);
    }

    @DisplayName("연산자 타입에 따라 계산이 진행된다 : - ")
    @Test
    void minus_operation(){
        int operand1 = 10;
        int operand2 = 2;
        OperatorType minusType = OperatorType.MINUS;

        CalculationExecutor sut = new CalculationExecutor();
        sut.calculate(operand1);
        sut.saveOperatorType(minusType);
        sut.calculate(operand2);

        Assertions.assertThat(sut.getResult()).isEqualTo(8);
    }

    @DisplayName("연산자 타입에 따라 계산이 진행된다 : / ")
    @Test
    void divide_operation(){
        int operand1 = 10;
        int operand2 = 2;
        OperatorType divideType = OperatorType.DIVIDE;

        CalculationExecutor sut = new CalculationExecutor();
        sut.calculate(operand1);
        sut.saveOperatorType(divideType);
        sut.calculate(operand2);

        Assertions.assertThat(sut.getResult()).isEqualTo(5);
    }

    @DisplayName("연산자 타입에 따라 계산이 진행된다 : * ")
    @Test
    void multiple_operation(){
        int operand1 = 10;
        int operand2 = 2;
        OperatorType multipleType = OperatorType.MULTIPLE;

        CalculationExecutor sut = new CalculationExecutor();
        sut.calculate(operand1);
        sut.saveOperatorType(multipleType);
        sut.calculate(operand2);

        Assertions.assertThat(sut.getResult()).isEqualTo(20);
    }
}
