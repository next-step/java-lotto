package calculator.domain.operator;

public class Divide extends Operator {

    public Divide(int target) {
        super(target);
    }

    @Override
    public int execute(int number) {
        return number / target;
    }
}
