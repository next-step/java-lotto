package stringcalculator;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import stringcalulator.model.Constant;
import stringcalulator.model.Operator;

public class OperatorTest {

    @ParameterizedTest
    @CsvSource({"1d, 2d, +", "3d, 5d, -", "2d, 5d, *", "4d, 2d, /"})
    void 연산자_동작_테스트(double firstValue, double secondValue, String operateSymbol) {

        double expected = calculateExpect(firstValue, secondValue, operateSymbol);
        double result = Operator.findOperator(operateSymbol).operate(firstValue, secondValue);
        Assertions.assertThat(result).isEqualTo(expected);

    }

    @Test
    void 나눗셈_0_테스트() {

        Assertions.assertThatThrownBy(
                        () -> Operator.DIV.operate(4d, 0)
                ).isInstanceOf(IllegalArgumentException.class)
                .hasMessage(Constant.Exception.DOES_NOT_DIVIDE_ZERO);
    }

    private double calculateExpect(double firstValue, double secondValue, String operateSymbol) {
        switch (operateSymbol) {
            case "+":
                return firstValue + secondValue;
            case "-":
                return firstValue - secondValue;
            case "*":
                return firstValue * secondValue;
            case "/":
                return firstValue / secondValue;
            default:
                return 0;
        }
    }

}

