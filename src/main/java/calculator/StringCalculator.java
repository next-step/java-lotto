package calculator;

import collection.IntegerWrapper;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class StringCalculator {
    public static int add(String s) {
        if (s == null || s.equals("")) {
            return 0;
        }

        String splitRegex = getSplitRegex(getCustomSeperator(s));
        s = s.replaceAll("^//.\\n", "");

        return getSum(s, splitRegex);
    }

    private static int getSum(String s, String splitRegex) {
        int sum = 0;
        for (String string : s.split(splitRegex)) {
            sum += new IntegerWrapper(string).getValue();
        }
        return sum;
    }

    /**
     * 스플릿 정규식 가져오기
     *
     * @param customSeperator 커스텀 구분자
     * @return
     */
    private static String getSplitRegex(String customSeperator) {
        StringBuilder sb = new StringBuilder(",|:");
        if (customSeperator != null && !customSeperator.isEmpty()) {
            sb.append("|" + customSeperator);
        }
        return sb.toString();
    }

    /**
     * 커스텀 구분자 가져오기
     *
     * @param str
     * @return
     */
    public static String getCustomSeperator(String str) {
        String cs = str.replaceAll("//|\\n.*$|,|:|\\d", "");

        return cs;
    }
}
