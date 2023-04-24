package step1;

import java.util.List;

public class Operators {
    private final List<Operator> operators;

    private Operators(List<Operator> operators) {
        validate(operators);
        this.operators = operators;
    }

    public static Operators of(List<Operator> operators) {
        return new Operators(operators);
    }

    private void validate(List<Operator> operators) {
        if (operators.isEmpty()) {
            throw new IllegalArgumentException("연산자가 없습니다.");
        }
    }

    public int length() {
        return operators.size();
    }

    public Operator getFromIndex(int index) {
        return operators.get(index);
    }
}
