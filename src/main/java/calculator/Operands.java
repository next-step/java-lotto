package calculator;

import java.util.LinkedList;
import java.util.Queue;

import static calculator.REGEX.NUMBER_PATTERN;

public class Operands {
    private Queue<Integer> operandQueue;

    public Operands(final String[] tokens) {
        this.operandQueue = initQueue(tokens);
    }

    private Queue<Integer> initQueue(final String[] tokens) {
        Queue<Integer> operandQueue = new LinkedList<>();
        for (String token : tokens) {
            addOperand(operandQueue, token);
        }
        return operandQueue;
    }

    private void addOperand(final Queue<Integer> operandQueue, final String token) {
        if (isNumber(token)) {
            operandQueue.add(Integer.valueOf(token));
        }
    }

    private boolean isNumber(final String token) {
        return NUMBER_PATTERN.matcher(token).find();
    }

    public int remove() {
        return operandQueue.remove();
    }
}
