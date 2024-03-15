package lotto;

import java.util.LinkedList;
import java.util.Queue;

public class Operators {

    private final Queue<String> operators;

    public Operators() {
        this.operators = new LinkedList<>();
    }

    public Queue<String> get() {
        return this.operators;
    }

    public void add(String operator) {
        this.operators.add(operator);
    }
}
