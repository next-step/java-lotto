package stringCalculator.operator;

import java.util.HashMap;
import java.util.Map;

public class OperatorMapping {
    private static Map<String, Operator> operatorMap = new HashMap<>();

    static {
        operatorMap.put("+", new SumOperator());
        operatorMap.put("-", new SubtractionOperator());
        operatorMap.put("*", new MultiplicationOperator());
        operatorMap.put("/", new DivisionOperator());
    }

    public static Operator returnOperation(String operator){
        return operatorMap.get(operator);
    }
}
