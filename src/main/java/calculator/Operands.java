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

}
