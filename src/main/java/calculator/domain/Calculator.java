package calculator.domain;

public class Calculator {

    public static int sum(String[] splitValues) {
        int result = 0;
        for (String value : splitValues) {
            result += Integer.parseInt(value);
        }
        return result;
    }
}
