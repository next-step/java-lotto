package calculator.domain;

import java.util.List;
import java.util.Objects;

public class Operators {
    private final List<OperatorType> operators;

    public Operators(List<OperatorType> operators) {
        this.operators = operators;
    }

    /**
     * @param operatorPosition 연산자의 위치 (0부터 입력해야 한다.)
     */
    public OperandNumber execute(int operatorPosition, OperandNumber first, OperandNumber second) {
        return operators.get(operatorPosition).execute(first, second);
    }

    public int size() {
        return operators.size();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Operators operators1 = (Operators) o;
        return operators.equals(operators1.operators);
    }

    @Override
    public int hashCode() {
        return Objects.hash(operators);
    }
}
