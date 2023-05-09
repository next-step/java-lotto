package step1.domain;

import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

public class Operations {

    private Deque<Operator> operators;

    public Operations(List<Operator> operators) {
        this.operators = new LinkedList<>(operators);
    }

    public boolean hasNext() {
        return !operators.isEmpty();
    }

    public Operator next() {
        if (operators.isEmpty()) {
            return null;
        }
        return operators.pollFirst();
    }

    public boolean isContain(Operator operator) {
        return operators.contains(operator);
    }

}
