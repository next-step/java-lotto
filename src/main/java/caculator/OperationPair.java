package caculator;

public class OperationPair {
    private Operator operator;
    private Number number;

    public OperationPair(Operator operator, Number number) {
        this.operator = operator;
        this.number = number;
    }

    public OperationPair(String operator, String number) {
        this.number = new Number(number);
        this.operator = new Operator(operator);
    }
}
