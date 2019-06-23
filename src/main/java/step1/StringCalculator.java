package step1;

public class StringCalculator {
    private static final int VALUE_FOR_EMPTY_INPUT = 0;

    public int calculate(String inputString) {
        if (isEmpty(inputString)) {
            return VALUE_FOR_EMPTY_INPUT;
        }
        return StringSplitter
                .splitToElements(inputString)
                .sum()
                .getValue();
    }

    private boolean isEmpty(String inputString) {
        return inputString == null || "".equals(inputString);
    }
}
