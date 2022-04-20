package stringcalculator.domain;

public class StringCalculator {
    public static Integer calculate(String input) {
        if (input == null || input.isEmpty()) {
            throw new IllegalArgumentException("Input cannot be null or empty");
        }
        String[] split = input.split(" ");

        int result = 0;
        for (int i = 0; i < split.length; i += 2) {
            result += Integer.parseInt(split[i]);
        }
        return result;
    }

}
