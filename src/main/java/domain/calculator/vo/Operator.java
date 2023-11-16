package domain.calculator.vo;

public class Operator {
    private final OperatorEnum value;

    public Operator(OperatorEnum value) {
        this.value = value;
    }

    public OperatorEnum getValue() {
        return value;
    }
}
