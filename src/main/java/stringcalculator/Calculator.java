package stringcalculator;

public class Calculator {

    public static String[] inputSpilt(String input) {
        if (input == null || input.isEmpty()) {
            throw new IllegalArgumentException("입력 값이 없습니다.");
        }
        return input.split(" ");
    }

    public static int calculate(String[] input) {
        int result = 0;

        int num1 = Integer.parseInt(input[0]);
        String operations = input[1];
        int num2 = Integer.parseInt(input[2]);
        result = getResult(num1, operations, num2);

        for (int i = 3; i < input.length - 1; i += 2) {
            num1 = result;
            operations = input[i];
            num2 = Integer.parseInt(input[i + 1]);
            result = getResult(num1, operations, num2);
        }

        return result;
    }

    public static int getResult(int num1, String operations, int num2) {
        if (operations.equals("+")) {
            return num1 + num2;
        }
        if (operations.equals("-")) {
            return num1 - num2;
        }
        if (operations.equals("*")) {
            return num1 * num2;
        }
        if (operations.equals("/")) {
            return num1 / num2;
        }
        throw new IllegalArgumentException("사칙연산 기호가 아닙니다");
    }
}
