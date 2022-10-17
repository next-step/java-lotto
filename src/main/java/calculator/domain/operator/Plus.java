package calculator.domain.operator;

public class Plus extends Operator {

    public Plus(int target) {
        super(target);
    }

    @Override
    public int execute(int number) {
        return number + target;
    }

    @Override
    public boolean equals(Object o) {
        if (!(o instanceof Plus)) {
            return false;
        }
        return target == ((Operator) o).target;
    }
}
