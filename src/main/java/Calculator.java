import java.util.*;
import java.util.stream.*;

public class Calculator {
    private List<String> values;

    public Calculator() {
        this("");
    }

    public Calculator(String input) {
        inputEmptyCheck(input);

        this.values = Stream.of(input.split(" "))
                .collect(Collectors.toCollection(ArrayList::new));
    }

    private void inputEmptyCheck(String input) {
        if (input == null || input.isEmpty()) {
            throw new IllegalArgumentException("입력 문자열이 빈 값 입니다.");
        }
    }

    public int plus(int left, int right) {
        return left + right;
    }

    public int minus(int left, int right) {
        return left - right;
    }

    public int multiply(int left, int right) {
        return left * right;
    }

    public int divide(int left, int right) {
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

    public int result() {
        while (this.values.size() != 1) {
            initAndCalculate();
        }

        return Integer.parseInt(this.values.get(0));
    }

    private void initAndCalculate() {
        int left = Integer.parseInt(this.values.remove(0));
        String operator = this.values.remove(0);
        int right = Integer.parseInt(this.values.remove(0));
        int result = 0;

        result = calculate(left, operator, right, result);

        this.values.add(0, String.valueOf(result));
    }

    private int calculate(int left, String operator, int right, int result) {
        if (operator.equals("+")) {
            result = plus(left, right);
        } else if (operator.equals("-")) {
            result = minus(left, right);
        } else if (operator.equals("*")) {
            result = multiply(left, right);
        } else if (operator.equals("/")) {
            result = divide(left, right);
        }

        return result;
    }
}
