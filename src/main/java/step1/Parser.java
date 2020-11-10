package step1;

public class Parser {
    private Parser() {}

    protected static final String LESS_THAN_ZERO_EXCEPTION_MSG = "숫자는 0보다 커야 합니다.";

    public static int parseNumStr(String numStr) {
        int num = Integer.parseInt(numStr);
        if (num < 0) {
            throw new RuntimeException(LESS_THAN_ZERO_EXCEPTION_MSG);
        }
        return num;
    }

    public static int[] parseNumStrArr(String[] numStrArr) {
        int length = numStrArr.length;
        int[] numArr = new int[length];
        for (int i = 0; i < length; i++) {
            numArr[i] = parseNumStr(numStrArr[i]);
        }
        return numArr;
    }
}
