package calculator.domain.operator;

public class Multiple extends Operator {

    public Multiple(int target) {
        super(target);
    }

    @Override
    public int execute(int number) {
        return number * target;
    }
}
