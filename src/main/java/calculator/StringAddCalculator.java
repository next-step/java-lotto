package calculator;

public class StringAddCalculator {

    private static final int ZERO_VALUE = 0;

    private StringAddCalculator() {
    }

    public static int splitAndSum(String str) {
        if (isEmpty(str)) {
            return ZERO_VALUE;
        }

        SplitNumber splitNumbers = getSplitter(str);

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
