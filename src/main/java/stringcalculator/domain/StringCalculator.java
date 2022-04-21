package stringcalculator.domain;

public class StringCalculator {
    public static Integer calculate(String input) {
        if (input == null || input.isEmpty()) {
            throw new IllegalArgumentException("Input cannot be null or empty");
        }
        String[] split = input.split(" ");

        int precedingOperand = toInt(split, 0);
        precedingOperand = getResultValue(split, precedingOperand);
        return precedingOperand;
    }

    private static int getResultValue(String[] split, int precedingOperand) {
        for (int i = 1; i < split.length; i += 2) {
            int followingOperand;
            followingOperand = toInt(split, i + 1);
            switch (split[i]) {
                case "+":
                    precedingOperand += followingOperand;
                    break;
                case "-":
                    precedingOperand -= followingOperand;
                    break;
                case "*":
                    precedingOperand *= followingOperand;
                    break;
                case "/":
                    if (followingOperand == 0) {
                        throw new IllegalArgumentException("Cannot divide by zero");
                    }
                    precedingOperand /= followingOperand;
                    break;
                default:
                    throw new IllegalArgumentException("Invalid operator");
            }
        }
        return precedingOperand;
    }

    private static int toInt(String[] split, int x) {
        try {
            return Integer.parseInt(split[x]);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("Invalid input");
        }
    }
}