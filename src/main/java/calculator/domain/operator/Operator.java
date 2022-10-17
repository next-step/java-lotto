package calculator.domain.operator;

public abstract class Operator {
    final int target;

    public Operator(int target) {
        this.target = target;
    }
    public abstract int execute(int number);

    @Override
    public boolean equals(Object o) {
        if (!(o instanceof Operator)) {
            return false;
        }
        return target == ((Operator) o).target;
    }
}
