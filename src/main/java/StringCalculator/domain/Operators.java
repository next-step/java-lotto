package StringCalculator.domain;

import StringCalculator.constant.Operator;
import java.util.LinkedList;
import java.util.Queue;

public class Operators {

    private final Queue<Operator> operators;

    public Operators() {
        operators = new LinkedList<>();
    }

    public Operators(Queue<Operator> operators) {
        this.operators = operators;
    }

    public boolean hasNext() {
        return 0 < operators.size();
    }

    public Operator remove() {
        return operators.remove();
    }

}
