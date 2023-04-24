package calculator.domain;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Operators {
    private final Queue<Operator> operators;

    public Operators(Queue<Operator> operators) {
        this.operators = operators;
    }

    public static Operators of(List<String> operators) {
        Queue<Operator> operatorList = new LinkedList<>();
        operators.forEach(operator -> operatorList.add(Operator.from(operator)));

        return new Operators(operatorList);
    }

    public int size() {
        return operators.size();
    }

    public Operator next() {
        return this.operators.poll();
    }
}
