package study;

public class Calculator {
    private Calculator() {
        throw new IllegalArgumentException("Utility Class");
    }

    public static int execute(String input) {
        inputValidate(input);
        String[] inputArray = input.split(" ");
        inputArrayValidate(inputArray.length % 2 == 0);

        int sum;
        sum = Integer.parseInt(inputArray[0]);
        for (int i = 1; i < inputArray.length; i++) {
            sum = checkAndCalculate(i, sum, inputArray);
        }
        return sum;
    }

    private static void inputArrayValidate(boolean length) {
        if (length) {
            throw new IllegalArgumentException("Input string is wrong.");
        }
    }

    private static void inputValidate(String input) {
        inputArrayValidate(input == null || input.isEmpty() || input.isBlank());
    }

    private static int checkAndCalculate(int index, int sum, String[] inputArray) {
        if (isOdd(index)) {
            sum = calculate(sum, inputArray[index], Integer.parseInt(inputArray[index + 1]));
        }
        return sum;
    }

    private static boolean isOdd(int index) {
        return index % 2 != 0;
    }

    private static int calculate(int sum, String operator, int other) {
        if (operator.equals("+")) {
            return sum + other;
        }
        if (operator.equals("-")) {
            return sum - other;
        }
        if (operator.equals("*")) {
            return sum * other;
        }
        if (operator.equals("/")) {
            return sum / other;
        }
        throw new IllegalArgumentException("Wrong operator!");
    }
}
