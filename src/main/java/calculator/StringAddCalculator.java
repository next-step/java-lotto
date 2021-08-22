package calculator;

public class StringAddCalculator {
    public static int splitAndSum(String text) {
        if (text == null || text.isEmpty()) {
            return 0;
        }

        return add(parseOperands(text));
    }

    static String[] parseOperands(String text) {
        return text.split(",");
    }

    static int add(String[] operands) {
        int sum = 0;

        for (int i = 0; i < operands.length; i++) {
            sum += Integer.parseInt(operands[i]);
        }

        return sum;
    }
}
