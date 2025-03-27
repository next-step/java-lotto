package calculator;

import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

public class StringCalculator {
    private final Queue<String> queue;

    public StringCalculator(Queue<String> queue) {
        this.queue = queue;

        if (queue == null || queue.size() % 2 == 0)
            throw new IllegalArgumentException("Invalid input.");
    }

    public int calculate() {
        if (queue.isEmpty())
            throw new IllegalStateException("this stringCalculator has already been closed");

        int leftOperand = Integer.parseInt(queue.remove());
        while (!queue.isEmpty()) {
            Operator operator = Operator.valueOfSymbol(queue.remove());
            int rightOperand = Integer.parseInt(queue.remove());

            leftOperand = operator.calculate(leftOperand, rightOperand);
        }

        return leftOperand;
    }

    public List<String> getQueue() {
        return new ArrayList<>(queue);
    }
}
