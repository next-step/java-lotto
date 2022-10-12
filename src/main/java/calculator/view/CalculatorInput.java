package calculator.view;

import calculator.domain.operator.Operator;

import java.util.List;

public class CalculatorInput {
    private int init;
    private List<Operator> operators;

    public int getInit() {
        return init;
    }

    public void setInit(int init) {
        this.init = init;
    }

    public List<Operator> getOperators() {
        return operators;
    }

    public void setOperators(List<Operator> operators) {
        this.operators = operators;
    }
}
