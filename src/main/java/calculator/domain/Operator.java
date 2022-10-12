package calculator.domain;

public abstract class Operator {
    final int target;

    public Operator(int target) {
        this.target = target;
    }
    public abstract int execute(int number);
}
