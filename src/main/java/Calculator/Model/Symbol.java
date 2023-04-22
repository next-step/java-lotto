package Calculator.Model;

import java.util.Arrays;

public class Symbol {
    private static final String[] OPERATORS_PERMITTED = {"+", "-", "*", "/"};

    private String symbol;
    public Symbol(String input) {
        if (isSymbol(input)) {
            symbol = input;
            return;
        }

        throw new IllegalArgumentException("연산자가 아닙니다.");
    }

    public boolean isSymbol(String input) {
        return Arrays.asList(OPERATORS_PERMITTED).contains(input);
    }

    public String currentSymbol() {
        return symbol;
    }

    public void changeSymbol(String symbol) {
        if (!isSymbol(symbol)) {
            throw new IllegalArgumentException("연산자가 아닙니다.");
        }

        this.symbol = symbol;
    }
}
