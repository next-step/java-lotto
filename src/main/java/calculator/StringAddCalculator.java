package calculator;

public class StringAddCalculator {

    public static int splitAndSum(String text) {
        if (text == null || text.trim().length() == 0) {
            return 0;
        }

        return Integer.parseInt(text);
    }
}
