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
    
    private int sum(int a, int b) {
        return a + b;
    }
}
