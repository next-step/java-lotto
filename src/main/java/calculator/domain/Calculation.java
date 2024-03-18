package calculator.domain;

import java.util.Deque;
import java.util.LinkedList;

import static calculator.Validator.*;

public class Calculation {
    private static final String WRONG_MATHEMATICAL_EXPRESSION_MESSAGE = "잘못된 수식입니다.";
    private static final String BLANK_DELIMITER = " ";
    private static final int MATHEMATICAL_EXPRESSION_MIN_COMPONENT = 3;

    public double calculate(String mathematicalExpression) {
        validateMathematicalExpression(mathematicalExpression);
        return calculationResult(makeOperandDeQueue(mathematicalExpression), makeOperatorDeQueue(mathematicalExpression));
    }

    private void validateMathematicalExpression(String mathematicalExpression) {
        if (!isNonBlank(mathematicalExpression)) {
            throw new IllegalArgumentException(WRONG_MATHEMATICAL_EXPRESSION_MESSAGE);
        }

        String[] operandOperatorArray = mathematicalExpression.split(BLANK_DELIMITER);
        if (!isGreaterThanOrEqualToLength(operandOperatorArray, MATHEMATICAL_EXPRESSION_MIN_COMPONENT) || !isOddNumberLength(operandOperatorArray)) {
            throw new IllegalArgumentException(WRONG_MATHEMATICAL_EXPRESSION_MESSAGE);
        }
    }

    private Deque<Operand> makeOperandDeQueue(String mathematicalExpression) {
        Deque<Operand> operandQueue = new LinkedList<>();
        String[] operandOperatorArray = mathematicalExpression.split(BLANK_DELIMITER);

        for (int i = 0; i < operandOperatorArray.length; i += 2) {
            operandQueue.add(Operand.valueOf(operandOperatorArray[i]));
        }

        return operandQueue;
    }

    private Deque<Operator> makeOperatorDeQueue(String mathematicalExpression) {
        Deque<Operator> operatorQueue = new LinkedList<>();
        String[] operandOperatorArray = mathematicalExpression.split(BLANK_DELIMITER);

        for (int i = 1; i < operandOperatorArray.length; i += 2) {
            operatorQueue.add(Operator.findOperator(operandOperatorArray[i]));
        }

        return operatorQueue;
    }

    private double calculationResult(Deque<Operand> operandDeQueue, Deque<Operator> operatorDeQueue ) {
        while (operandDeQueue.size() > 1 && !operatorDeQueue.isEmpty()) {
            Operator operator = operatorDeQueue.poll();
            double result = operator.calculate(numberFromOperandDeQueue(operandDeQueue), numberFromOperandDeQueue(operandDeQueue));
            operandDeQueue.addFirst(Operand.valueOf(String.valueOf(result)));
        }

        return numberFromOperandDeQueue(operandDeQueue);
    }

    private double numberFromOperandDeQueue(Deque<Operand> operandQueue) {
        Operand operand = operandQueue.poll();
        return operand.value();
    }
}
