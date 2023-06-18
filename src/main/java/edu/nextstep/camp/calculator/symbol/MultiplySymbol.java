package edu.nextstep.camp.calculator.symbol;

public class MultiplySymbol implements CalculateSymbol {

    private static final String MULTIPLY_SYMBOL = "*";

    @Override
    public int calculate(int number, int calculateNumber) {
        return number * calculateNumber;
    }

    @Override
    public String getSymbol() {
        return MULTIPLY_SYMBOL;
    }
}
