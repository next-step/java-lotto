package study;

public class OperationLinker {


    public static int link(int a, int b, String operator) {

        if (operator.equals("+")) {
            return Calculator.plus(a, b);
        }
        if (operator.equals("-")) {
            return Calculator.minus(a, b);
        }
        if (operator.equals("*")) {
            return Calculator.multiply(a, b);
        }
        if (operator.equals("/")) {
            return Calculator.divide(a, b);
        }
        throw new IllegalArgumentException("연산자가 잘못되었습니다.");
    }
}
