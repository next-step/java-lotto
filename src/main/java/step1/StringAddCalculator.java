package step1;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringAddCalculator {

    private static final String CHECK_CUSTOM_REGEX = "^//.*\\n.*$";
    private static final String EXTRACT_DELIMITER_REGEX = "^//(.*?)\\n.*$";
    private static final String EXTRACT_NUMS_REGEX = "^//.*\\n(.*?)$";
    private static final String SPLIT_REGEX = ",|:";

    public static int splitAndSum(String input) {
        if (checkZero(input)) {
            return 0;
        }
        if (checkSingle(input)) {
            return parseNumStr(input);
        }
        return calcSum(input);
    }

    private static boolean checkZero(String input) {
        return checkNull(input) || checkEmpty(input);
    }

    private static boolean checkNull(String input) {
        return input == null;
    }

    private static boolean checkEmpty(String input) {
        return input.isEmpty();
    }

    private static boolean checkSingle(String input) {
        return splitInput(input).length < 1;
    }

    private static int parseNumStr(String numStr) {
        int num = Integer.parseInt(numStr);
        validateNum(num);
        return num;
    }

    private static int[] parseNumStrArr(String[] numStrArr) {
        int length = numStrArr.length;
        int[] numArr = new int[length];
        for (int i = 0; i < length; i++) {
            numArr[i] = parseNumStr(numStrArr[i]);
        }
        return numArr;
    }

    private static int calcSum(int[] numArrr) {
        int sum = 0;
        for (int num: numArrr) {
            sum += num;
        }
        return sum;
    }

    private static int calcSum(String input) {
        String[] numStrArr = splitInput(input);
        int[] numArr = parseNumStrArr(numStrArr);
        return calcSum(numArr);
    }

    private static String extract(String str, String regex) {
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(str);
        if (matcher.find()) {
            return matcher.group(1);
        }
        return null;
    }

    private static String extractCustomDelimiter(String input) {
        return extract(input, EXTRACT_DELIMITER_REGEX);
    }

    private static String extractNums(String input) {
        return extract(input, EXTRACT_NUMS_REGEX);
    }

    private static boolean checkCustomDelimiter(String input) {
        return input.matches(CHECK_CUSTOM_REGEX);
    }

    private static String addDelimiter(String splitRegex, String delimiter) {
        String or = "|";
        return splitRegex + or + delimiter;
    }

    private static String[] splitCustomInput(String input) {
        String delimiter = extractCustomDelimiter(input);
        String customRegex = addDelimiter(SPLIT_REGEX, delimiter);
        input = extractNums(input);
        return input.split(customRegex);
    }

    private static String[] splitInput(String input) {
        if (checkCustomDelimiter(input)) {
            return splitCustomInput(input);
        }
        return input.split(SPLIT_REGEX);
    }

    private static void validateNum(int num) {
        if (num < 0) {
            throw new RuntimeException();
        }
    }
}
