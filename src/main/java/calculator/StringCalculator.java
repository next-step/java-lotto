package calculator;

import collection.IntegerWrapper;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringCalculator {
    private StringCalculator() {
        throw new IllegalStateException("Utility class");
    }

    /**
     * 더하기
     * @param str
     * @return
     */
    public static int add(String str) {
        if (str == null || str.isEmpty()) {
            return 0;
        }

        return sum(toInt(split(str)));
    }

    /**
     * 숫자 배열로 변환
     * @param values
     * @return
     */
    private static int[] toInt(String[] values) {
        int[] ints = new int[values.length];
        for (int i = 0; i < values.length; i++) {
            int num = new IntegerWrapper(values[i]).getValue();
            ints[i] = num;
        }

        return ints;
    }

    /**
     * 총합 구하기
     * @param values
     * @return
     */
    private static int sum(int[] values) {
        int sum = 0;
        for (int value : values) {
            sum += value;
        }
        return sum;
    }

    /**
     * 분리하기
     * @param value
     * @return
     */
    private static String[] split(String value) {
        Matcher matcher = Pattern.compile("//(.)\n(.*)").matcher(value);

        if(matcher.find()) {
            String customDelimiter = matcher.group(1);
            return matcher.group(2).split(customDelimiter);
        }

        return value.split(",|:");
    }
}
