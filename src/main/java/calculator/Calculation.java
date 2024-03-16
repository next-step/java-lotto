package calculator;

import java.util.Deque;
import java.util.LinkedList;

import static calculator.Validator.*;

public class Calculation {
    private static final String WRONG_MATHEMATICAL_EXPRESSION_MESSAGE = "잘못된 수식입니다.";
    private static final String BLANK_DELIMITER = " ";
    private static final int MATHEMATICAL_EXPRESSION_MIN_COMPONENT = 3;

    private final Deque<Operand> operandQueue;
    private final Deque<Operator> operatorQueue;

    private Calculation(String mathematicalExpression) {
        if(!isNonBlank(mathematicalExpression)) {
            throw new IllegalArgumentException(WRONG_MATHEMATICAL_EXPRESSION_MESSAGE);
        }

        String[] operandOperatorArray = mathematicalExpression.split(BLANK_DELIMITER);

        if(!isGreaterThanOrEqualToLength(operandOperatorArray, MATHEMATICAL_EXPRESSION_MIN_COMPONENT) || !isOddNumberLength(operandOperatorArray)) {
            throw new IllegalArgumentException(WRONG_MATHEMATICAL_EXPRESSION_MESSAGE);
        }

        this.operandQueue = makeOperandQueue(operandOperatorArray);
        this.operatorQueue = makeOperatorQueue(operandOperatorArray);
    }

    public static Calculation newCalculation(String mathematicalExpression) {
        return new Calculation(mathematicalExpression);
    }

    private Deque<Operand> makeOperandQueue(String[] operandOperatorArray) {
        Deque<Operand> operandQueue = new LinkedList<>();

        for(int i = 0; i < operandOperatorArray.length; i+=2) {
            operandQueue.add(Operand.newOperand(operandOperatorArray[i]));
        }

        return operandQueue;
    }

    private Deque<Operator> makeOperatorQueue(String[] operandOperatorArray) {
        Deque<Operator> operatorQueue = new LinkedList<>();

        for(int i = 1; i < operandOperatorArray.length; i+=2) {
            operatorQueue.add(Operator.findOperator(operandOperatorArray[i]));
        }

        return operatorQueue;
    }

    public double calculate() {
        while(operandQueue.size() > 1 && !operatorQueue.isEmpty()) {
            Operator operator = operatorQueue.poll();
            double result = operator.calculate(numFromOperandQueue(), numFromOperandQueue());
            operandQueue.addFirst(Operand.newOperand(String.valueOf(result)));
        }

        return numFromOperandQueue();
    }

    private double numFromOperandQueue() {
        Operand operand = operandQueue.poll();
        return operand.value();
    }
}
