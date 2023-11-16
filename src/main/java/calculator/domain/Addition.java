package calculator.domain;

public class Addition implements Operator {

    public int operate(int first, int second) {
        return first + second;
    }
}
