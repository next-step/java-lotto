import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringAddCalculator {

    public static int splitAndSum(String parameter) {
        int result = 0;

        if (parameter == null || parameter.isEmpty()) {
            return result;
        }

        String[] paramArray = makeStringArray(parameter);

        for (int i = 0; i < paramArray.length; i++) {
            result = calculate(result , Integer.parseInt(paramArray[i]));
        }
        return result;
    }

    public static String[] makeStringArray(String parameter) {
        Matcher m = Pattern.compile("//(.)\n(.*)").matcher(parameter);
        if (m.find()) {
            String customDelimiter = m.group(1);
            String[] tokens = m.group(2).split(customDelimiter);

            return tokens;
        }
        return parameter.split(",|:");
    }

    public static int calculate(int currNum, int otherNum) {
        if (otherNum < 0) {
            throw new RuntimeException();
        }
        return currNum + otherNum;
    }

}
