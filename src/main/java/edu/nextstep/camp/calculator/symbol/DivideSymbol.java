package edu.nextstep.camp.calculator.symbol;

public class DivideSymbol implements CalculateSymbol {

    private static final String DIVIDE_SYMBOL = "/";

    @Override
    public int calculate(int number, int calculateNumber) {
        return number / calculateNumber;
    }

    @Override
    public String getSymbol() {
        return DIVIDE_SYMBOL;
    }
}
