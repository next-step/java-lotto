package step1.model;

import step1.domain.Operand;
import step1.domain.Operator;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Operators {

    private List<Operator> operators = new ArrayList<>();
    private static final Operators instance = new Operators();


    public static Operators getInstance() {
        return instance;
    }

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
