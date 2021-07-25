package calculator;

public class StringAddCalculator {

    private static final int ZERO_VALUE = 0;

    private StringAddCalculator() {
    }

    public static int splitAndSum(String separateStr) {
        if (isEmpty(separateStr)) {
            return ZERO_VALUE;
        }

        SplitNumber splitNumbers = SplitType.split(separateStr);

        return splitNumbers.splitNumberToInt();
    }

    private static boolean isEmpty(String str) {
        return str == null || str.isEmpty();
    }
}
