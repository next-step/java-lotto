package stringcalculator.domain;

public class StringCalculator {
    public static Integer calculate(String input) {
        if (input == null || input.isEmpty()) {
            throw new IllegalArgumentException("Input cannot be null or empty");
        }
        String[] split = input.split(" ");

        int result = Integer.parseInt(split[0]);
        for (int i = 1; i < split.length; i += 2) {
            if (split[1].equals("+")) {
                result += Integer.parseInt(split[i + 1]);
            } else if (split[1].equals("-")) {
                result -= Integer.parseInt(split[i + 1]);
            } else if (split[1].equals("*")) {
                result *= Integer.parseInt(split[i + 1]);
            }
        }
        return result;
    }

}
