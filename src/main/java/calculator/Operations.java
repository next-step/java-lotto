package calculator;

import java.util.LinkedList;
import java.util.Queue;

import static calculator.REGEX.NUMBER_PATTERN;

public class Operations {
    private final Queue<Operation> operationQueue;

    public Operations(String[] tokens) {
        this.operationQueue = initQueue(tokens);
    }

    private Queue<Operation> initQueue(final String[] tokens) {
        Queue<Operation> operationQueue = new LinkedList<>();
        for (String token : tokens) {
            addOperation(operationQueue, token);
        }

        return operationQueue;
    }

    private static void addOperation(final Queue<Operation> operationQueue, final String token) {
        if (isNotNumber(token)) {
            operationQueue.add(Operation.fromString(token));
        }
    }

    private static boolean isNotNumber(final String token) {
        return !NUMBER_PATTERN.matcher(token).find();
    }

    public int calculate(final Operands operands) {
        int result = operands.remove();

        while (isQueueNotEmpty()) {
            final Operation operation = operationQueue.remove();
            result = operation.calculate(result, operands.remove());
        }

        return result;
    }

    private boolean isQueueNotEmpty() {
        return !this.operationQueue.isEmpty();
    }
}
