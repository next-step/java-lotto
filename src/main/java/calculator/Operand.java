package calculator;

import java.util.Objects;

public class Operand {
    
    private int operand;
    
    public Operand(String parseResult) {
        this.operand = parseStringToInteger(parseResult);
        checkNegative(operand);
    }
    
    public int getOperand() {
        return operand;
    }
    
    private int parseStringToInteger(String parseResult) {
        try {
            return Integer.parseInt(parseResult);
        } catch (NumberFormatException e) {
            throw new NumberFormatException("피연산자가 숫자가 아닙니다.");
        }
        
    }
    
    private void checkNegative(int operand) {
        if (operand < 0) {
            throw new RuntimeException("음수입니다");
        }
    }
    
    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Operand operand1 = (Operand) o;
        return operand == operand1.operand;
    }
    
    @Override
    public int hashCode() {
        return Objects.hash(operand);
    }
}
