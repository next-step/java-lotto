package domain;

public class Operand {

    private static final String NUMBER_PATTERN = "^[0-9]+$";

    private int operand;

    private Operand(String operand) {
        this.operand = Integer.parseInt(operand);
    }

    private Operand(int operand) {
        this.operand = operand;
    }

    public static Operand findOperand(String operand) {
        return new Operand(operand);
    }

    public static Operand from(int operand) {
        return new Operand(operand);
    }

    public static boolean isOperand(String inputValue) {
        return inputValue.matches(NUMBER_PATTERN);
    }

    public int getOperand() {
        return operand;
    }

}
