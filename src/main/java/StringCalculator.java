import java.util.Arrays;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringCalculator {
    public int calculate(String text) {
        if(checkNullString(text) || checkEmptyString(text)) {
            return 0;
        }

        if(checkOnlyOneText(text)) {
            return Integer.parseInt(text);
        }

        if(checkCustomDelimiter(text)) {
            return sumCustomDelimiter(text);
        }

        return sum(text.split(",|:"));
    }

    private int sumCustomDelimiter(String text) {
        Matcher m = Pattern.compile("//(.)\n(.*)").matcher(text);
        String[] tokens = {""};
        if (m.find()) {
            String customDelimiter = m.group(1);
            tokens = m.group(2).split(customDelimiter);
        }
        return sum(tokens);
    }

    private boolean checkCustomDelimiter(String text) {
        return text.startsWith("//");
    }

    private int sum(String[] texts) {
        return Arrays.stream(texts)
                .mapToInt(Integer::parseInt)
                .sum();
    }

    private boolean checkOnlyOneText(String text) {
        Matcher m = Pattern.compile("^[0-9]+$").matcher(text);
        return m.find();
    }

    private boolean checkEmptyString(String text) {
        return text.isEmpty();
    }

    private boolean checkNullString(String text) {
        return text == null;
    }

}
