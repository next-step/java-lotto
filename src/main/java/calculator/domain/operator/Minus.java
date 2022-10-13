package calculator.domain.operator;

public class Minus extends Operator {
    public Minus(int target) {
        super(target);
    }

    @Override
    public int execute(int number) {
        return number - target;
    }

    @Override
    public boolean equals(Object o) {
        if (!(o instanceof Minus)) {
            return false;
        }
        return target == ((Operator) o).target;
    }
}
