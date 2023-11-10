package step1;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Operators {
    private List<Operator> operators = new ArrayList<>();

    public Operators(List<Operator> operators) {
        this.operators = operators;
    }

    public Operators() {
    }

    public void addOperator(String operator) {
        operators.add(Operator.findOperatorEnum(operator));
    }

    public boolean hasElement() {
        return operators.size() != 0;
    }

    public int calculate(int first, int second, int index) {
        return operators.get(index).calculate(first, second);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Operators operators1 = (Operators) o;
        return Objects.equals(operators, operators1.operators);
    }

    @Override
    public int hashCode() {
        return Objects.hash(operators);
    }


}
