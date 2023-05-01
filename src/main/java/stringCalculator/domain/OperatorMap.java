package stringCalculator.domain;

import stringCalculator.strategy.*;

import java.util.HashMap;
import java.util.Map;

public class OperatorMap {

    private static String PLUS = "+";
    private static String MINUS = "-";
    private static String MULTIPLY = "*";
    private static String DIVIDE = "/";

    private Map<String, CalculatorStrategy> strategyMap;

    public OperatorMap() {
        create();
    }

    private void create() {
        this.strategyMap = new HashMap<>();

        strategyMap.put(PLUS, new PlusStrategy());
        strategyMap.put(MINUS, new MinusStrategy());
        strategyMap.put(MULTIPLY, new MultiplyStrategy());
        strategyMap.put(DIVIDE, new DivideStrategy());
    }

    public CalculatorStrategy getStrategy(String operator) {
        isOperator(operator);

        return this.strategyMap.get(operator);
    }

    private void isOperator(String operator) {

        if(strategyMap.get(operator) == null) {
            throw new IllegalArgumentException("사칙 연산 문자열이 올바르지 않습니다.");
        }
    }

}
