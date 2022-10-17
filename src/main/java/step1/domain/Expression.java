package step1.domain;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import step1.util.ExpressionValidator;

public class Expression {

    private final Operands operands;

    private final Operators operators;

    private static final String SEPARATOR = " ";

    private Expression(Operands operands, Operators operators) {
        this.operands = operands;
        this.operators = operators;
    }

    public Operands getOperands() {
        return this.operands;
    }

    public Operators getOperators() {
        return this.operators;
    }

    public static Expression from(String rawExpression) {
        ExpressionValidator.validate(rawExpression);
        List<String> components = List.of(rawExpression.split(SEPARATOR));
        Map<Boolean, List<String>> classifiedComponents = components.stream()
                .collect(Collectors.partitioningBy(i -> components.indexOf(i) % 2 == 0));
        List<String> operands = classifiedComponents.get(true);
        List<String> operators = classifiedComponents.get(false);
        return new Expression(Operands.of(operands), Operators.of(operators));
    }
}
