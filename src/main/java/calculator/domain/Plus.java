package calculator.domain;

public class Plus implements Operator {
    private final int target;

    public Plus(int target) {
        this.target = target;
    }

    @Override
    public int execute(int number) {
        return number + target;
    }
}
