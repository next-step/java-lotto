package tdd;

public class StringAddCalculator {

    private static final int INIT_RESULT_VALUE = 0;

    public int add(String inputText) {
        if (inputText == null || inputText.isEmpty()) {
            return INIT_RESULT_VALUE;
        }

        String[] numbers = inputText.split(",");

        int result = INIT_RESULT_VALUE;
        for (String each : numbers) {
            int number = Integer.valueOf(each);
            result += number;
        }

        return result;
    }
}
