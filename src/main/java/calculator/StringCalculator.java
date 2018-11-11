package calculator;

import collection.PositiveNumber;

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
    public static Long add(String str) {
        if (str == null || str.isEmpty()) {
            return 0L;
        }

        return sum(toLong(split(str)));
    }

    /**
     * 숫자 배열로 변환
     * @param values
     * @return
     */
    private static Long[] toLong(String[] values) {
        Long[] nums = new Long[values.length];
        for (int i = 0; i < values.length; i++) {
            Long num = new PositiveNumber(values[i]).getValue();
            nums[i] = num;
        }

        return nums;
    }

    /**
     * 총합 구하기
     * @param values
     * @return
     */
    private static Long sum(Long[] values) {
        Long sum = 0L;
        for (Long value : values) {
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
