package arithmetic.operator;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;

import arithmetic.exception.InvalidExpressionException;

public class Expression {
    private final String expression;

    public Expression(String expression) {
        this.expression = expression;
    }

    public List<Number> numbers() {
        if (isInvalidExpression()) {
            throw new InvalidExpressionException();
        }
        return numbers(getBlankedExpression());
    }

    public List<Operation> operations() {
        if (isInvalidExpression()) {
            throw new InvalidExpressionException();
        }
        return operations(getBlankedExpression());
    }

    private boolean isInvalidExpression() {
        if (expression == null || expression.isBlank()) {
            return true;
        }
        
        long operatorCount = Pattern.compile("[+\\-|*|/]").matcher(expression).results().count();
        long numberCount = Pattern.compile("\\d").matcher(expression).results().count();
        return numberCount - 1 != operatorCount;
    }

    private String getBlankedExpression() {
        return expression.replaceAll("\\s", "");
    }

    private List<Number> numbers(String expression) {
        List<Number> numbers = new ArrayList<>();
        for (String number : expression.split("[+\\-|*|/]")) {
            numbers.add(new Number(Integer.parseInt(number)));
        }
        return numbers;
    }
    
    private List<Operation> operations(String expression) {
        List<String> operations = new ArrayList<>();
        for (String operation : expression.split("\\d")) {
            if (!operation.isBlank()) {
                operations.add(operation);
            }
        }
        return operations(operations);
    }

    private List<Operation> operations(List<String> operations) {
        List<Operation> result = new ArrayList<>();
        for (String operation : operations) {
            result.add(Operator.of(operation).getOperation());
        }
        return result;
    }
}
