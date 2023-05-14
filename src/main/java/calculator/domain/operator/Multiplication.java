package calculator.domain.operator;

public class Multiplication implements Operator {

    @Override
    public int operate(int a, int b) {
        return a * b;
    }

    @Override
    public String symbol() {
        return "*";
    }

}
