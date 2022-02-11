package calculator;

import java.util.List;

public class Adder {
    
    private final List<Operand> operands;
    
    public Adder(List<Operand> tokens) {
        this.operands = tokens;
    }
    
    public int calculate() {
        return operands.stream().mapToInt(Operand::getOperand).sum();
    }
}
