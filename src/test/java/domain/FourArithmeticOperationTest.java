package domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class FourArithmeticOperationTest {

    @DisplayName("연산 기호와 숫자 2개를 입력해 결과 도출")
    @Test
    void calculateFourArithmeticOperation() {
        String plusSymbol = "+";
        String minusSymbol = "-";
        String multpleSymbol = "*";
        String divideSymbol = "/";

        int leftOperand = 10;
        int rightOeprand = 2;

        FourArithmeticOperation operation = new FourArithmeticOperation();
        assertThat(operation.calculateFourArithmeticOperation(plusSymbol, leftOperand, rightOeprand)).isEqualTo(12);
        assertThat(operation.calculateFourArithmeticOperation(minusSymbol, leftOperand, rightOeprand)).isEqualTo(8);
        assertThat(operation.calculateFourArithmeticOperation(multpleSymbol, leftOperand, rightOeprand)).isEqualTo(20);
        assertThat(operation.calculateFourArithmeticOperation(divideSymbol, leftOperand, rightOeprand)).isEqualTo(5);
    }
}