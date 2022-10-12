package calculator.domain;

public class Plus extends Operator {

    public Plus(int target) {
        super(target);
    }

    @Override
    public int execute(int number) {
        return number + target;
    }
}
