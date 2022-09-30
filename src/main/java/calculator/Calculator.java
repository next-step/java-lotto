package calculator;

public class Calculator {

    public static final String ADD_OPERATOR = "+";
    public static final String SUB_OPERATOR = "-";
    public static final String MULTIPLY_OPERATOR = "*";
    public static final String DIV_OPERATOR = "/";

    public static int add(int leftNum, int rightNum) {
        return leftNum + rightNum;
    }

    public static int sub(int leftNum, int rightNum) {
        return leftNum - rightNum;
    }

    public static int multiply(int leftNum, int rightNum) {
        return leftNum * rightNum;
    }

    public static int div(int leftNum, int rightNum) {
        return leftNum / rightNum;
    }
}
