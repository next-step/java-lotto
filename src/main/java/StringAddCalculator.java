import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringAddCalculator {

    public static int splitAndSum(String input) {
        if(input == null || "".equals(input.trim())) {
            return 0;
        }

        String delimiterRegex = ",|:";

        Matcher m = Pattern.compile("//(.)\n(.*)").matcher(input);
        if (m.find()) {
            String customDelimiter = m.group(1);
            delimiterRegex += "|" + customDelimiter;
            input = m.group(2);
        }

        String[] numbers = input.split(delimiterRegex);

        Integer result = 0;
        for(String numberString : numbers) {
            Integer number = Integer.parseInt(numberString);
            if(number < 0) {
                throw new RuntimeException("음수 포함");
            }
            result += number;
        }
        return result;
    }
}
