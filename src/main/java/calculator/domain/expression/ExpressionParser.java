package calculator.domain.expression;

import java.util.Arrays;
import java.util.List;

public class ExpressionParser {

    public static final String DELIMITER = " ";
    private final Operands operands;
    private final Operators operators;

    public static ExpressionParser of(String calculationExpression) {
        List<String> expression = splitWithBlack(calculationExpression);
        Operands operands = Operands.extractOperand(expression);
        Operators operators = Operators.extractOperator(expression);
        validateCalculationExpression(operands, operators);
        return new ExpressionParser(operands, operators);
    }

    public ExpressionParser(Operands operands, Operators operators) {
        this.operands = operands;
        this.operators = operators;
    }


    private static void validateCalculationExpression(Operands operands, Operators operators) {
        if (operands.isInValid() || operators.isInValid() || operators.hasInValidSizeWithOperands(operands)) {
            throw new IllegalArgumentException("Invalid calculation expression");
        }
    }

    public Operands extractOperands() {
        return new Operands(operands);
    }

    public Operators extractOperators() {
        return new Operators(operators);
    }

    public static List<String> splitWithBlack(String calculationExpression) {
        validateMessage(calculationExpression);
        String[] splitedString = calculationExpression.split(DELIMITER);
        return Arrays.asList(splitedString);
    }

    private static void validateMessage(String calculationExpression) {
        if (calculationExpression == null || calculationExpression.isEmpty()) {
            throw new IllegalArgumentException("No calculation expression has been entered");
        }
    }
}
