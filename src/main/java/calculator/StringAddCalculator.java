package calculator;

public class StringAddCalculator {

    private static final int ZERO_VALUE = 0;

    private StringAddCalculator() {
    }

    public static int splitAndSum(String separateStr) {
        if (isEmpty(separateStr)) {
            return ZERO_VALUE;
        }

        SplitNumber splitNumbers = getSplitter(separateStr);

        return splitNumbers.splitNumberToInt();
    }

    private static SplitNumber getSplitter(String str) {
        SplitType splitType= SplitType.getSplitType(str);
        Splitter splitter = splitType.getSplitter();

        return splitter.split(str);
    }

    private static boolean isEmpty(String str) {
        return str == null || str.isEmpty();
    }
}
