package edu.nextstep.camp.calculator.symbol;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class CalculateSymbolTest {

    @Test
    void 덧셈() {
        CalculateSymbol calculateSymbol = new AddSymbol();

        int result = calculateSymbol.calculate(2, 5);

        assertThat(result).isEqualTo(7);
    }

    @Test
    void 뺄셈() {
        CalculateSymbol calculateSymbol = new SubtractSymbol();

        int result = calculateSymbol.calculate(6, 2);

        assertThat(result).isEqualTo(4);
    }

    @Test
    void 곱셈() {
        CalculateSymbol calculateSymbol = new MultiplySymbol();

        int result = calculateSymbol.calculate(6, 2);

        assertThat(result).isEqualTo(12);
    }

    @Test
    void 나눗셈() {
        CalculateSymbol calculateSymbol = new DivideSymbol();

        int result = calculateSymbol.calculate(9, 2);

        assertThat(result).isEqualTo(4);
    }
}
