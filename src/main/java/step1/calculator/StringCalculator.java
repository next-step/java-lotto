package step1.calculator;

import step1.validator.OperationValidator;

import java.util.ArrayDeque;
import java.util.Deque;

public class StringCalculator {

    private static final OperationValidator validator = new OperationValidator();
    private static final String BLANK = " ";

    public StringCalculator() {
    }

    public int evaluate(String input) {
        validator.assertOperation(input);
        return evaluatePostFix(toPostFix(input));
    }

    private String toPostFix(String input) {
        StringBuilder sb = new StringBuilder();
        String[] tokens = input.split(BLANK);
        Deque<String> operandQueue = new ArrayDeque<>();

        for (int i = 0; i < tokens.length; i++) {
            convertToPostfix(sb, operandQueue, tokens[i]);
        }

        while (!operandQueue.isEmpty()) {
            sb.append(operandQueue.poll()).append(BLANK);
        }

        return sb.toString();
    }

    private void convertToPostfix(StringBuilder sb, Deque<String> operandQueue, String token) {
        if (Character.isDigit(token.charAt(0))) {
            sb.append(token).append(BLANK);
            return;
        }

        operandQueue.add(token);
    }

    private int evaluatePostFix(String postFix) {
        String[] tokens = postFix.split(BLANK);
        Deque<Integer> operandQueue = new ArrayDeque<>();

        for (int i = 0; i < tokens.length; i++) {
            evaluatePostfixExpression(operandQueue, tokens[i]);
        }

        return operandQueue.poll();
    }

    private void evaluatePostfixExpression(Deque<Integer> operandQueue, String token) {
        if (Character.isDigit(token.charAt(0))) {
            operandQueue.add(Integer.valueOf(token));
            return;
        }

        Operation operation = Operation.find(token);
        int operand1 = operandQueue.poll();
        int operand2 = operandQueue.poll();

        operandQueue.addFirst(operation.apply(operand1, operand2));
    }
}
