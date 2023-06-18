package edu.nextstep.camp.calculator.symbol;

public class AddSymbol implements CalculateSymbol {
    private static final String PLUS_SYMBOL = "+";

    @Override
    public int calculate(int number, int calculateNumber) {
        return number + calculateNumber;
    }

    @Override
    public String getSymbol() {
        return PLUS_SYMBOL;
    }
}
