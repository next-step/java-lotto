package step1.calculator;

import java.util.HashMap;
import java.util.Map;

public class OperatorFactory {
    public static Calculator createCalculator(String operator) {

        Map<String, Calculator> calculatorMap = new HashMap<>();
        calculatorMap.put("+", new AddCalculator());
        calculatorMap.put("-", new MinusCalculator());
        calculatorMap.put("*", new MultiplyCalculator());
        calculatorMap.put("/", new DivideCalculator());

        return calculatorMap.get(operator);
    }
}
