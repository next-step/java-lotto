package calculator.domain.expression;

import calculator.domain.operation.*;

import java.util.List;

public class ExpressionCalculator {
    private static final List<ArithmeticOperation> ARITHMETIC_CALCULATORS = List.of(
            new AdditionOperation(),
            new SubtractionOperation(),
            new MultiplicationOperation(),
            new DivisionOperation()
    );

    private ExpressionCalculator() {
    }

    public static int calculateExpression(Operands operands, Operators operators) {
        int intermediateResult = operands.next().toInt();

        while (operators.getNumberOfOperators() > 0) {
            Operand firstOperand = new Operand(intermediateResult);
            Operator currentOperator  = operators.next();
            Operand nextOperand  = operands.next();
            intermediateResult = ExpressionCalculator.calculate(firstOperand, currentOperator , nextOperand);
        }

        return intermediateResult;
    }

    public static int calculate(Operand firstOperand, Operator operator, Operand nextOperand) {
        return ARITHMETIC_CALCULATORS.stream()
                .filter(arithmeticOperators -> arithmeticOperators.supports(operator))
                .map(arithmeticOperators -> arithmeticOperators.calculate(firstOperand, nextOperand))
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException("Invalid arithmetic operation"));
    }
}
