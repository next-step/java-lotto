package calculator.domain.operator;

public class Minus extends Operator {
    public Minus(int target) {
        super(target);
    }

    @Override
    public int execute(int number) {
        return number - target;
    }
}
