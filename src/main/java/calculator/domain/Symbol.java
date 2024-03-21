package calculator.domain;

import calculator.enums.OperatorEnum;

public class Symbol {

    private final String symbol;

    public Symbol(String symbol) {
        this.symbol = OperatorEnum.fromString(symbol);
    }

    public String getSymbol() {
        return this.symbol;
    }
}
