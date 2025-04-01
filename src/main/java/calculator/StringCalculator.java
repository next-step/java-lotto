package calculator;

public class StringCalculator {

    public static int calculate(String input) {

        String[] values = input.split(" ");
        String operation;
        int result = Integer.parseInt(values[0]);

        for (int i = 1; i < values.length; i++) {
            operation = values[i];
            i++;
            int number = Integer.parseInt(values[i]);
            result = calculate(result, operation, number);
        }

        return result;
    }

    private static int calculate(int number1, String operation, int number2) {
        switch (operation) {
            case "+":
                return number1 + number2;
            case "-":
                return number1 - number2;
            case "*":
                return number1 * number2;
            case "/":
                return number1 / number2;
            default:
                throw new IllegalArgumentException("Invalid operation: " + operation);
        }
    }
}
