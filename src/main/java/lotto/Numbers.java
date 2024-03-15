package lotto;

import java.util.LinkedList;
import java.util.Queue;

public class Numbers {

    private final Queue<Integer> numberQueue;

    public Numbers() {
        this.numberQueue = new LinkedList<>();
    }

    public void add(int number) {
        this.numberQueue.add(number);
    }

    public Queue<Integer> get() {
        return this.numberQueue;
    }

}
