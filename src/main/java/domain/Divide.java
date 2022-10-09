package domain;

public class Divide implements Calculator {

    private static final String SYMBOL = "/";

    @Override
    public boolean findMatchSymbol(String symbol) {
        return SYMBOL.equals(symbol);
    }

    @Override
    public int calculateWithSymbol(Integer a, Integer b) {
        return zeroDivisionValidation(a, b);
    }

    private int zeroDivisionValidation(Integer a, Integer b) {
        int result = 0;

        try {
            result = a / b;
        } catch (Exception e) {
            return result;
        }
        return result;
    }
}
