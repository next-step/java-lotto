package edu.nextstep.camp.calculator.symbol;

public class SubtractSymbol implements CalculateSymbol {
    private static final String MINUS_SYMBOL = "-";

    @Override
    public int calculate(int number, int calculateNumber) {
        return number - calculateNumber;
    }

    @Override
    public String getSymbol() {
        return MINUS_SYMBOL;
    }
}
