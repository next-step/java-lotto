package stringcalculator;

import java.util.LinkedList;
import java.util.Objects;
import java.util.Queue;

public class Operators {

    private Queue<Operator> operators;

    public Operators(Queue<Operator> operators) {
        this.operators = operators;
    }

    public void offer(Operator operator) {
        this.operators.offer(operator);
    }

    public Operator next() {
        return this.operators.poll();
    }

    public Queue<Operator> clone() {
        return new LinkedList<>(operators);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Operators that = (Operators) o;
        return Objects.equals(operators, that.operators);
    }

    @Override
    public int hashCode() {
        return Objects.hash(operators);
    }

}
