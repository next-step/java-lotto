package domain;

public class Multiply implements Calculator {

    private static final String SYMBOL = "*";

    @Override
    public boolean findMatchSymbol(String symbol) {
        return SYMBOL.equals(symbol);
    }

    @Override
    public int calculateWithSymbol(Integer a, Integer b) {
        return a * b;
    }
}
