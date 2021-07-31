package calculator;

public class StringAddCalculator {

    private static final int NULL_OR_EMPTY_RESULT = 0;

    private StringAddCalculator() {
    }

    public static int splitAndSum(String inputText) {
        if (isBlank(inputText)) {
            return NULL_OR_EMPTY_RESULT;
        }

        Numbers numbers = Numbers.from(Splitter.split(inputText));
        return numbers.sum();
    }

    private static boolean isBlank(String inputText) {
        return inputText == null || inputText.isEmpty();
    }

}
