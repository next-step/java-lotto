package calculator;

import java.util.List;

public class Operands {

    private final List<Operand> operands;

    public Operands(List<Operand> operands) {
        this.operands = operands;
    }

    public int size() {
        return operands.size();
    }

    public int sum() {
        int total = 0;

        for (Operand operand : operands) {
            total += operand.getNumber();
        }

        return total;
    }
}
