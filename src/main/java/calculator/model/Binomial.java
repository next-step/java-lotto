package calculator.model;

import java.util.List;

public class Binomial {
    private final int leftNumber;
    private final int rightNumber;
    private final Operator operator;


    public Binomial(List<String> tokens) {
        this.leftNumber = Integer.parseInt(tokens.get(0));
        this.operator = Operator.getBySymbol(tokens.get(1));
        this.rightNumber = Integer.parseInt(tokens.get(2));
    }

    public Operator getOperationType() {
        return this.operator;
    }

    public int getLeftNumber() {
        return this.leftNumber;
    }

    public int getRightNumber() {
        return this.rightNumber;
    }
}
