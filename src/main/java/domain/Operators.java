package domain;

import java.util.ArrayList;
import java.util.List;

public class Operators {
    private final List<Operator> operators;
    private int index;

    public Operators() {
        this.operators = new ArrayList<>();
        this.index = 0;
    }

    public Operators(List<Operator> operators) {
        this.operators = operators;
        this.index = 0;
    }

    public void addOperator(Operator operator) {
        this.operators.add(operator);
    }

    public Operator getNextOperator() {
        return this.operators.get(index++);
    }

    public boolean hasNextOperator() {
        return index < operators.size();
    }
}
