package stringCalculator;

import java.util.HashMap;
import java.util.Map;

public class OperatorFactory {
    private static final Map<String, CalculatorImplement> calculatorMap = new HashMap<>();

    static {
        calculatorMap.put("+", new PlusCalculator());
        calculatorMap.put("-", new SubtractionCalculator());
        calculatorMap.put("*", new MultipleCalculator());
        calculatorMap.put("/", new DivisionCalculator());
    }

    public static CalculatorImplement getCalculator(String operator) {
        CalculatorImplement calculator = calculatorMap.get(operator);
        if (calculator == null) {
            throw new IllegalArgumentException("Invalid operator: " + operator);
        }
        return calculator;
    }
}
