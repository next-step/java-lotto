package calculator;

import java.util.Map;
import java.util.Optional;

public class Operations {
    private final Map<String, Operation> operators;

    public Operations(Map<String, Operation> operators) {
        this.operators = operators;
    }

    public Optional<Operation> operationOf(String operator) {
        return Optional.ofNullable(operators.get(operator));
    }

    public void addOperator(String operator, Operation operation) {
        operators.put(operator, operation);
    }

    public boolean hasOperator(String operator) {
        return this.operators.containsKey(operator);
    }
}
