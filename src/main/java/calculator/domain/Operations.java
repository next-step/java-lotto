package calculator.domain;

import java.util.LinkedList;
import java.util.Queue;
import java.util.regex.Pattern;

public class Operations {
    private static final Pattern NUMBER_PATTERN = Pattern.compile("[^0-9]+");
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

    @Override
    public String toString() {
        return "Operations{" +
                "operationQueue=" + operationQueue.toString() +
                '}';
    }
}
