package step1;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringAddCalculator {
    private static final String CHECK_CUSTOM_REGEX = "^//.*\\n.*$";
    private static final String EXTRACT_DELIMITER_REGEX = "^//(.*?)\\n.*$";
    private static final String EXTRACT_NUMS_REGEX = "^//.*\\n(.*?)$";
    private static final String SPLIT_REGEX = ",|:";

    private static String extract(String str, String regex) {
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(str);
        if (matcher.find()) {
            return matcher.group(1);
        }
        return null;
    }

    private static String extractCustomDelimiter(String str) {
        return extract(str, EXTRACT_DELIMITER_REGEX);
    }

    private static String extractNums(String str) {
        return extract(str, EXTRACT_NUMS_REGEX);
    }

    private static boolean checkCustomDelimiter(String str) {
        return str.matches(CHECK_CUSTOM_REGEX);
    }

    private static boolean checkNull(String str) {
        return str == null;
    }

    private static boolean checkEmpty(String str) {
        return str.isEmpty();
    }

    private static boolean checkZero(String str) {
        return checkNull(str) || checkEmpty(str);
    }

    private static String addDelimiter(String regex, String delimiter) {
        String or = "|";
        return regex + or + delimiter;
    }

    private static String[] splitCustomStr(String str) {
        String delimiter = extractCustomDelimiter(str);
        String customRegex = addDelimiter(SPLIT_REGEX, delimiter);
        str = extractNums(str);
        return str.split(customRegex);
    }

    private static String[] splitStr(String str) {
        if (checkCustomDelimiter(str)) {
            return splitCustomStr(str);
        }
        return str.split(SPLIT_REGEX);
    }

    private static void validateNum(int num) {
        if (num < 0) {
            throw new RuntimeException();
        }
    }

    private static int parseStr(String str) {
        int num = Integer.parseInt(str);
        validateNum(num);
        return Integer.parseInt(str);
    }

    private static boolean checkSingle(String str) {
        return splitStr(str).length < 1;
    }

    private static int[] parseStrArr(String[] strArr) {
        int length = strArr.length;
        int[] arr = new int[length];
        for (int i = 0; i < length; i++) {
            arr[i] = parseStr(strArr[i]);
        }
        return arr;
    }

    private static int calcSum(int[] arr) {
        int sum = 0;
        for (int num: arr) {
            sum += num;
        }
        return sum;
    }

    private static int calcSum(String str) {
        String[] strArr = splitStr(str);
        int[] intArr = parseStrArr(strArr);
        return calcSum(intArr);
    }

    public static int splitAndSum(String str) {
        if (checkZero(str)) {
            return 0;
        }
        if (checkSingle(str)) {
            return parseStr(str);
        }
        return calcSum(str);
    }
}
