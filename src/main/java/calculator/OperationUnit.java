package calculator;

public class OperationUnit {
    private final int left;
    private final char operand;
    private final int right;

    public OperationUnit(int left, char operand, int right) {
        if(invalidOperand(operand)) {
            throw new IllegalArgumentException("지원하지 않는 연산자 입니다.");
        }

        this.left = left;
        this.operand = operand;
        this.right = right;
    }

    private boolean invalidOperand(char operand) {
        char[] supportedOperands = {'+','-','*','/'};
        for (char supportedOperand : supportedOperands) {
            if (operand == supportedOperand) {
                return false;
            }
        }

        return true;
    }

    public int getLeft() {
        return left;
    }

    public char getOperand() {
        return operand;
    }

    public int getRight() {
        return right;
    }
}
