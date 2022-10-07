package stringcalculator;

public class StringCalculator {

    public static String isBlank(String data) {
        if (data == null || data.trim().isEmpty()) {
            throw new IllegalArgumentException();
        }
        return data;
    }

    public static String[] split(String data) {
        return isBlank(data).split(" ");
    }

    public static int calculate(String[] data) {
        int result = Integer.parseInt(data[0]);
        for (int i = 1; i < data.length - 1; i += 2) {
            result = operatorCheck(data[i], Integer.parseInt(data[i + 1]), result);
        }
        return result;
    }

    public static int operatorCheck(String operator, int num, int result) {
        if (operator == "+") {
            return add(num, result);
        }
        if (operator == "-") {
            return subtract(num, result);
        }
        if (operator == "*") {
            return multiply(num, result);
        }
        if (operator == "/") {
            return divide(num, result);
        }
        throw new IllegalArgumentException();
    }

    public static int add(int num, int result) {
        return result + num;
    }

    public static int subtract(int num, int result) {
        return result - num;
    }

    public static int multiply(int num, int result) {
        return result * num;
    }

    public static int divide(int num, int result) {
        return result / num;
    }
}
