package calculator.model;

import java.util.List;

public class Operators {

    private List<String> operators;

    public Operators(List<String> operators) {
        this.operators = operators;
    }

    public List<String> findOperator(){
        List<String> findOperator = List.of(operators.get(0));
        operators.remove(0);
        return findOperator;
    }

    public int size(){
        return this.operators.size();
    }
}
