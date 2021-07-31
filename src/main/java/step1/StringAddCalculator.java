package step1;

public class StringAddCalculator {

    public static int splitAndSum(String input) {
        int result = 0;

        if (input == null || input.isEmpty()) {
            return result;
        }

        StringCalculatorParser parse = new StringCalculatorParser(input);
        String[] parsedString = parse.parser();
        return sum(parsedString);

    }

    private static int sum(String[] split) {
        int result = 0;
        for (String str : split) {
            result += Integer.parseInt(str);
        }
        return result;
    }
}
