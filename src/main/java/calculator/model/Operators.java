package calculator.model;

import calculator.domain.Operator;

import java.util.ArrayList;
import java.util.List;

public class Operators {

    private List<Operator> operators = new ArrayList<>();

    public void addOperator(Operator operator) {
        this.operators.add(operator);
    }

    public int size() {
        return this.operators.size();
    }

    public Operator getOperator(int index) {
        return this.operators.get(index);
    }

    public void clear() {
        this.operators = new ArrayList<>();
    }
}
