import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringAddCalculator {
    public static int splitAndSum(String calcStr) {
        int result = 0;

        if (calcStr == null || calcStr.isEmpty()) {
            return 0;
        }

        Matcher m = Pattern.compile("//(.)\n(.*)").matcher(calcStr);
        if (m.find()) {
            String customDelimiter = m.group(1);
            String[] tokens= m.group(2).split(customDelimiter);

            for (String number: tokens) {
                result += Integer.parseInt(number);
            }
        }
        else {
            String[] numbers = calcStr.split(",|:");
            for (String number: numbers) {
                result += Integer.parseInt(number);
            }
        }

        return result;
    }
}
