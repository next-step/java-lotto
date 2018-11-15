import java.util.Objects;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringCalculator {

    public static int calculator(String data) {
        if (isBlank(data))
            return 0;
        return addition(parseData(data));
    }

    private static int addition(String[] numbers) {
        int result = 0;
        for (String number : numbers) {
            result += toPositive(number);
        }
        return result;
    }

    private static int toPositive(String number) {
        int value = Integer.parseInt(number);
        if (value < 0) {
            throw new RuntimeException("음수를 입력할 수 없습니다.");
        }
        return value;
    }

    private static String[] parseData(String data) {
        Matcher matcher = Pattern.compile("//(.)\n(.*)").matcher(data);
        if (matcher.find()) {
            String customDelimiter = matcher.group(1);
            return splitData(matcher.group(2), customDelimiter + "|,|:");
        }
        return splitData(data, ",|:");
    }

    private static String[] splitData(String data, String delimiter) {
        return data.split(delimiter);
    }

    private static boolean isBlank(String data) {
        return Objects.isNull(data) || data.isEmpty();
    }
}

