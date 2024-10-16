package calculator.model;

import calculator.domain.Operand;

import java.util.ArrayList;
import java.util.List;

public class Operands {

    private List<Operand> operands = new ArrayList<>();

    public void addOperand(Operand operand) {
        this.operands.add(operand);
    }

    public int size() {
        return this.operands.size();
    }

    public int get(int index) {
        Operand operand = this.operands.get(index);
        return operand.getValue();
    }

    public void clear() {
        this.operands = new ArrayList<>();
    }
}
