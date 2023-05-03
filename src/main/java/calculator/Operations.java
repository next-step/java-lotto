package calculator;

import java.util.Map;

public class Operations {
    private final Map<String, Operation> operators;

    public Operations(Map<String, Operation> operators) {
        this.operators = operators;
    }

    public Operation operationOf(String operator) {
        return operators.get(operator);
    }

    public void addOperator(String operator, Operation operation) {
        operators.put(operator, operation);
    }

    public boolean hasOperator(String operator) {
        return this.operators.containsKey(operator);
    }
}
