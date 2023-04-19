package step1;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class OperatorParser {
    private static final Map<String, Boolean> SYMBOLS = Map.of(
            Operator.PLUS.getSymbol(), true,
            Operator.MINUS.getSymbol(), true,
            Operator.MULTIPLY.getSymbol(), true,
            Operator.DIVIDE.getSymbol(), true
    );
    public List<Operator> parse(String input) {
        List<Operator> operators = new ArrayList<>();
        for (int i = 0; i < input.length(); i++) {
            addOperator(input, operators, i);
        }
        return operators;
    }

    private void addOperator(String input, List<Operator> operators, int i) {
        final String symbol = String.valueOf(input.charAt(i));
        if (isOperator(symbol)) {
            operators.add(Operator.valueOf(symbol));
        }
    }

    private boolean isOperator(String symbol) {
        return SYMBOLS.getOrDefault(symbol, false);
    }
}
