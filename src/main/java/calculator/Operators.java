package calculator;

import java.util.Map;

public class Operators {
    private final Map<String, Operator> operators;

    public Operators(Map<String, Operator> operators) {
        this.operators = operators;
    }

    public Operator operationOf(String operator) {
        return operators.get(operator);
    }

    public void addOperator(String operator, Operator operation) {
        operators.put(operator, operation);
    }

    public boolean hasOperator(String operator) {
        return this.operators.containsKey(operator);
    }
}
