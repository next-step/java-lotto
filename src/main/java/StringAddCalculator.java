import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringAddCalculator {
    public static int splitAndSum(String calcStr) {
        if (isBlank(calcStr)) {
            return 0;
        }

        if (!isContainDelimiter(calcStr)) {
            return strToInt(calcStr);
        }

        return splitStr(calcStr);
    }

    private static int strToInt(String calcStr) throws RuntimeException {
        int num = Integer.parseInt(calcStr);
        if (num < 0) {
            throw new RuntimeException();
        }

        return num;
    }

    private static int splitStr(String calcStr) {
        if (isDefaultDelimiter(calcStr)) {
            String[] numbers = calcStr.split(",|:");
            return sum(numbers);
        }

        return splitWithCustomDelimiter(calcStr);
    }

    private static int splitWithCustomDelimiter(String calcStr) {
        Matcher m = Pattern.compile("//(.)\n(.*)").matcher(calcStr);

        if (m.find()) {
            String customDelimiter = m.group(1);
            String[] tokens = m.group(2).split(customDelimiter);
            return sum(tokens);
        }

        return 0;
    }

    private static int sum(String[] numbers) {
        int sum = 0;
        for (String number: numbers) {
            sum += strToInt(number);
        }

        return sum;
    }

    private static boolean isContainDelimiter(String calcStr) {
        return isDefaultDelimiter(calcStr) || isCustomDelimiter(calcStr);
    }

    private static boolean isDefaultDelimiter(String calcStr) {
        return calcStr.contains(",") || calcStr.contains(":");
    }

    private static boolean isCustomDelimiter(String calcStr) {
        return calcStr.matches("//(.)\n(.*)");
    }

    private static boolean isBlank(String calcStr) {
        return calcStr == null || calcStr.isEmpty();
    }
}
