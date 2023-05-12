package lotto.step1.domain;

import java.util.ArrayDeque;
import java.util.Deque;

public class MathOpQueue {
    private final Deque<String> mathOperationQueue;

    public MathOpQueue(Deque<String> mathOperationQueue) {
        this.mathOperationQueue = mathOperationQueue;
    }

    public void analyzeOperation(Input input) {
        input.getCalcList().forEach(e -> {
            if (!input.isDigit(e)) {
                mathOperationQueue.add(e);
            }
        });
    }

    public int getSize() {
        return mathOperationQueue.size();
    }

    public boolean isEmpty() {
        return mathOperationQueue.isEmpty();
    }

    public String poll() {
        return mathOperationQueue.poll();
    }


    public Deque<String> getMathOperationQueue() {
        return mathOperationQueue;
    }
}
