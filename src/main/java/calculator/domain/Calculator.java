package calculator.domain;

import java.util.List;

public class Calculator {
    private int number;
    private final List<Operator> inputOperator;


    public Calculator(int init, List<Operator> inputOperator) {
        this.number = init;
        this.inputOperator = inputOperator;
    }

    public int calculate() {
        for (Operator operator: inputOperator) {
            number = operator.execute(number);
        }

        return number;
    }
}
