package domain;

import java.util.ArrayList;
import java.util.List;

public class Operands {
    private final List<Operand> operands;
    private int currIndex;

    public Operands() {
        this.operands = new ArrayList<>();
        this.currIndex = 0;
    }

    public Operands(List<Operand> operands) {
        this.operands = operands;
        this.currIndex = 0;
    }

    public void addOperand(Operand operand) {
        this.operands.add(operand);
    }

    public Operand getNextOperand() {
        return this.operands.get(currIndex++);
    }

    public boolean hasNextOperand() {
        return currIndex < operands.size();
    }
}
