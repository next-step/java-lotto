package step1;

public class Operand {

    private int operand;

    public Operand(String operand) {
        try {
            this.operand = Integer.valueOf(operand);
        } catch (NumberFormatException numberFormatException) {
            throw new IllegalArgumentException("피연산자에는 문자가 올 수 없습니다.");
        }
    }

    public int getOperand() {
        return operand;
    }
}
