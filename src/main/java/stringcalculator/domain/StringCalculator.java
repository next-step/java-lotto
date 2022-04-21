package stringcalculator.domain;

public class StringCalculator {
    public static Integer calculate(String input) {
        if (input == null || input.isEmpty()) {
            throw new IllegalArgumentException("Input cannot be null or empty");
        }
        String[] split = input.split(" ");

        int result = toInt(split, 0);
        for (int i = 1; i < split.length; i += 2) {
            int result2;
            result2 = toInt(split, i + 1);
            if ("+".equals(split[i])) {
                result += result2;
            } else if ("-".equals(split[i])) {
                result -= result2;
            } else if ("*".equals(split[i])) {
                result *= result2;
            } else if ("/".equals(split[i])) {
                if (result2 == 0) {
                    throw new IllegalArgumentException("Cannot divide by zero");
                }
                result /= result2;
            }
        }
        return result;
    }

    private static int toInt(String[] split, int x) {
        try {
            return Integer.parseInt(split[x]);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("Invalid input");
        }
    }
}