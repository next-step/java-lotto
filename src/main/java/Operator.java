public class Operator {
    int left;
    String operator;
    int right;

    public Operator() {
        this(0, "+", 0);
    }

    public Operator(int left, String operator, int right) {
        this.left = left;
        this.operator = operator;
        this.right = right;
    }

    public void init(int left, String operator, int right) {
        this.left = left;
        this.operator = operator;
        this.right = right;
    }

    public int operate() {
        if (operator.equals("+")) {
            return plus(left, right);
        } else if (operator.equals("-")) {
            return minus(left, right);
        } else if (operator.equals("*")) {
            return multiply(left, right);
        } else if (operator.equals("/")) {
            return divide(left, right);
        }

        throw new IllegalArgumentException("유효한 연산자가 아닙니다.");
    }

    private int plus(int left, int right) {
        return left + right;
    }

    private int minus(int left, int right) {
        return left - right;
    }

    private int multiply(int left, int right) {
        return left * right;
    }

    private int divide(int left, int right) {
        validateDivision(left, right);

        return left / right;
    }

    private void validateDivision(int left, int right) {
        checkZero(right);
        checkInteger(left, right);
    }

    private void checkZero(int right) {
        if (right == 0) {
            throw new IllegalArgumentException("0으로 나눌 수 없습니다.");
        }
    }

    private void checkInteger(int left, int right) {
        if (left % right != 0) {
            throw new IllegalArgumentException("정수로 나누어지지 않습니다.");
        }
    }
}
