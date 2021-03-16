package StringAddCalculator;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Operands {
    private final List<Operand> operands;

    public Operands(List<Operand> operands) {
        this.operands = operands;
    }

    public Operands(String[] operands) {
        this.operands = new ArrayList<>();
        for (String number : operands) {
            this.operands.add(new Operand(number));
        }
    }

    public Operand sum() {
        Operand sum = new Operand(0);
        for (Operand o : operands) {
            sum = sum.add(o);
        }
        return sum;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Operands operands1 = (Operands) o;
        return Objects.equals(operands, operands1.operands);
    }

    @Override
    public int hashCode() {
        return Objects.hash(operands);
    }
}
