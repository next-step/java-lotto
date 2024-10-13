package step1.model;

import step1.domain.Operand;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Operands {

    private List<Operand> operands = new ArrayList<>();
    private static final Operands instance = new Operands();

    public static Operands getInstance() {
        return instance;
    }

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
