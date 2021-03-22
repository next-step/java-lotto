/*
* Operand 집합을 포장하는 클래스
* */
package Calculator;

import java.util.List;
import java.util.Objects;
import java.util.function.BinaryOperator;

public class Operands {
    private List<Operand> operands;

    public Operands(List<Operand> operands) {
        this.operands = operands;
    }

    public Operand operateAll(BinaryOperator<Integer> operator) {
        Operand result = new Operand(0);
        for (Operand operand : operands) {
            result = operand.operate(result, operator);
        }
        return result;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Operands operands1 = (Operands) o;
        return operands.containsAll(operands1.operands);
    }

    @Override
    public int hashCode() {
        return Objects.hash(operands);
    }
}
