package lotto.step1.domain;

import java.util.ArrayDeque;
import java.util.Deque;

public class NumberQueue {
    private final Deque<Integer> numberQueue;

    public NumberQueue(Deque<Integer> numberQueue) {
        this.numberQueue = numberQueue;
    }

    public void analyzeNumber(Input input) {
        input.getCalcList().forEach(e -> {
            if (input.isDigit(e)) {
                numberQueue.add(Integer.parseInt(e));
            }
        });
    }

    public boolean isEmpty() {
        return numberQueue.isEmpty();
    }

    public int poll() {
        return numberQueue.poll();
    }

    public void addFirst(int element) {
        numberQueue.addFirst(element);
    }

    public Deque<Integer> getNumberQueue() {
        return numberQueue;
    }

    public int getSize() {
        return numberQueue.size();
    }
}
