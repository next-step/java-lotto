package edu.nextstep.camp.calculator;

import edu.nextstep.camp.calculator.symbol.*;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class IntNumber {

    private int number;

    private Map<String, CalculateSymbol> symbolsMap;

    public IntNumber() {
        this("0");
    }

    public IntNumber(String number) {
        this(number, List.of(new AddSymbol(), new SubtractSymbol(), new MultiplySymbol(), new DivideSymbol()));
    }

    public IntNumber(String number, List<CalculateSymbol> symbols) {
        this.number = toInt(number);
        symbolsMap = symbols.stream()
                .collect(Collectors.toMap(symbol -> symbol.getSymbol(), symbol -> symbol));
    }

    public int calculateBaseSymbol(String symbol, String calculateNumber) {
        if (symbol == null || symbol.isBlank()) {
            throw new IllegalArgumentException("symbol is blank or null");
        }

        if (!symbolsMap.containsKey(symbol)) {
            throw new IllegalArgumentException("not support symbol");
        }

        return number = symbolsMap.get(symbol)
                .calculate(number, toInt(calculateNumber));
    }

    public int getValue() {
        return number;
    }

    private int toInt(String numberStr) {
        if (numberStr == null || numberStr.isBlank()) {
            throw new IllegalArgumentException("number is blank or null");
        }

        return Integer.parseInt(numberStr);
    }
}
