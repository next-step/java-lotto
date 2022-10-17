package step1.domain;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import step1.util.OperatorConverter;

public class Operators implements Iterable<Operator> {

    private final Queue<Operator> operators;

    private Operators(Queue<Operator> operators) {
        this.operators = operators;
    }

    public Operator poll() {
        return operators.poll();
    }

    @Override
    public boolean equals(Object o) {
        if (o instanceof Operators) {
            return this.operators.equals(((Operators) o).operators);
        }
        return false;
    }

    @Override
    public Iterator<Operator> iterator() {
        return this.operators.iterator();
    }

    public static Operators of(List<String> rawOperators) {
        Queue<Operator> operators = new LinkedList<>();
        for (String rawOperator : rawOperators) {
            Operator operator = OperatorConverter.convert(rawOperator);
            operators.add(operator);
        }
        return new Operators(operators);
    }
}
