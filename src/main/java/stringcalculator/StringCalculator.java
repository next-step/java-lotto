package stringcalculator;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringCalculator {
    private static final String DEFAULT_SEPARATOR =  ",|:";
    private static final String CUSTOM_SEPARATOR_REGEX = "//(.)\n(.*)";
    private static final int SUBSEQUENCE_FIRST_SEPARATOR = 1;
    private static final int SUBSEQUENCE_SECOND_INPUT = 2;

    public static String[] split(String input) {
        Matcher m = Pattern.compile(CUSTOM_SEPARATOR_REGEX).matcher(input);
        if (m.find()) {
            String customSeparator = m.group(SUBSEQUENCE_FIRST_SEPARATOR);
            return m.group(SUBSEQUENCE_SECOND_INPUT).split(customSeparator);
        }

        return input.split(DEFAULT_SEPARATOR);
    }

    public static int[] stringsToInts(String input) {
        String[] pieces = split(input);

        int[] result = new int[pieces.length];

        for(int i = 0; i < pieces.length; i++) {
            result[i] = stringToInteger(pieces[i]);
        }

        return result;
    }

    private static Integer stringToInteger(String s) {
        Integer result = null;

        try {
            result = Integer.parseInt(s);
        } catch (NumberFormatException e) {
            throw new RuntimeException("숫자 이외의 값을 전달할 수 없습니다.");
        }

        if(result < 0) {
            throw new RuntimeException("음수를 전달할 수 없습니다.");
        }

        return result;
    }

    public static int sum(String s) {
        int result = 0;

        if(s == null || s.isEmpty()) {
            return result;
        }

        int[] ints = stringsToInts(s);

        for(int element: ints) {
            result += element;
        }

        return result;
    }
}
