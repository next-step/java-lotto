package calculator.domain;

import calculator.domain.AddExpression;
import calculator.domain.CalculatorExpression;
import calculator.domain.DivideExpression;
import calculator.domain.MinusExpression;
import calculator.domain.MultiplicationExpression;
import java.util.HashMap;
import java.util.Map;
import java.util.function.BiFunction;
import java.util.function.Function;

public class CalculatorService {

    private static Map<Character, BiFunction<VariableExpression,VariableExpression, CalculatorExpression>> expressionMap;

    public CalculatorService() {
        expressionMap = new HashMap<>();
        expressionMap.put('+', AddExpression::new);
        expressionMap.put('-', MinusExpression::new);
        expressionMap.put('*', MultiplicationExpression::new);
        expressionMap.put('/', DivideExpression::new);
    }

    public BiFunction<VariableExpression, VariableExpression, CalculatorExpression> typeOfExpression(char mark){
        return expressionMap.get(mark);
    }
}
