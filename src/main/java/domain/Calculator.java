package domain;

public class Calculator {
    private int nowValue;
    private Operation operation;

    public Calculator() {
    }
    public int getNowValue() {
        return nowValue;
    }

    public void basic(int now) {
        this.nowValue = now;
    }

    public void operation(int num, String symbol) {
        operation = Operation.of(symbol);
        this.nowValue = operation.apply(nowValue, num);
    }
}
