package stringcalculator.domain;

public class StringCalculator {
    public static Integer calculate(String input) {
        if (input == null || input.isEmpty()) {
            throw new IllegalArgumentException("Input cannot be null or empty");
        }
        String[] split = input.split(" ");

        int precedingOperand = toInt(split, 0);

        for (int i = 1; i < split.length; i += 2) {
            precedingOperand = Operator.operation(split[i], precedingOperand, toInt(split, i + 1));
        }
//        precedingOperand = getResultValue(split, precedingOperand);
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