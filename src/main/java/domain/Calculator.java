package domain;

public class Calculator {
    private int nowValue;

    public Calculator() {
    }

    public int getNowValue() {
        return nowValue;
    }
    private static final String add = "+";
    private static final String multiply  = "*";
    private static final String division = "/";
    private static final String minus = "-";

    public void basic(int now) {
        this.nowValue = now;
    }

    private void add(int num) {
        this.nowValue = nowValue + num;
    }

    private void multiply(int num) {
        this.nowValue = nowValue * num;
    }

    private void division(int num) {
        this.nowValue = nowValue / num;
    }

    private void minus(int num) {
        this.nowValue = nowValue - num;
    }

    public int operation(int num, String symbol) {
        switch (symbol) {
            case add:
                add(num);
                break;
            case minus:
                minus(num);
                break;
            case division:
                division(num);
                break;
            case multiply:
                multiply(num);
                break;
            default:
                throw new IllegalArgumentException("잘못된 기호 입니다");
        }
        return nowValue;
    }
}
