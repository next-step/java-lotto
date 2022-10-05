package calculator;

public class Operand {
    private int operand;

    private Operand(int operand) {
        this.operand = operand;
    }

    private Operand(String operand) {
        this(Integer.parseInt(operand));
    }

    public static Operand from(String operand) {
        return new Operand(operand);
    }

    public static Operand from(int operand) {
        return new Operand(operand);
    }

    public int getResult() {
        return operand;
    }

    public static boolean isOperand(String token) {
        for (char word : token.toCharArray()) {
            if (!Character.isDigit(word)) {
                return false;
            }
        }
        return true;
    }

    public Operand plus(Operand right) {
        return Operand.from(this.operand + right.operand);
    }

    public Operand minus(Operand right) {
        return Operand.from(this.operand - right.operand);
    }

    public Operand multiply(Operand right) {
        return Operand.from(this.operand * right.operand);
    }

    public Operand divide(Operand right) {
        if (right.operand == 0) {
            throw new IllegalArgumentException("0으로 나눌 수 없습니다.");
        }
        return Operand.from(this.operand / right.operand);
    }
}
