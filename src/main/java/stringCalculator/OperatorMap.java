package stringCalculator;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static stringCalculator.Calculator.*;

public class OperatorMap {
    private static Map<String, Calculator> operatorMap = new HashMap<>();

    static {
        operatorMap.put("+", PLUS);
        operatorMap.put("-", MINUS);
        operatorMap.put("*", MULTIPLE);
        operatorMap.put("/", DIVIDE);
    }

    public int calculate(int a, int b, Values values) {
        int result = getOperator(values.pollOperator()).calculate(a, b);

        if (!values.isEmptyOperator()) {
            return calculate(result, values.pollOperand(), values);
        }

        return result;
    }

    private Calculator getOperator(String operator) {
        return operatorMap.get(operator);
    }

    public static List<String> getOperatorKey() {
        return new ArrayList<>(operatorMap.keySet());
    }
}
