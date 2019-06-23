import org.assertj.core.util.Strings;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringCalculator {
    private final static int SUM_FAILED = 0;

    public int add(String input) throws Exception {
        if (Strings.isNullOrEmpty(input))
            return SUM_FAILED;

        if (input.length() == 1)
            return Integer.parseInt(input);

        if (input.contains("//"))
            return splitCustomSum(input);

        return splitAndSum(input);
    }

    private int splitAndSum(String input) {
        String[] result = input.split(",|:");
        return getSumofArray(result);
    }

    private int splitCustomSum(String input) {
        Matcher m = Pattern.compile("//(.)\n(.*)").matcher(input);
        if (m.find()) {
            String customDelimiter = m.group(1);
            String[] tokens = m.group(2).split(customDelimiter);
            return getSumofArray(tokens);
        }
        return SUM_FAILED;
    }

    private int getSumofArray(String[] inputs) {
        int sum = 0;
        for (int i = 0; i < inputs.length; ++i) {
            sum += Integer.parseInt(inputs[i]);
        }
        return sum;
    }
}
