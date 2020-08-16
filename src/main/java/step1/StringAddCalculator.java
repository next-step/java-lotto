package step1;

import java.util.Arrays;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringAddCalculator {

    public static int splitAndSum(String operand) throws RuntimeException {
        if (operand == null) {
            return 0;
        }
        Matcher matcher = Pattern.compile("//(.)\n(.*)").matcher(operand);
        if (matcher.find()) {
            if ("".equals(matcher.group(2))) {
                return 0;
            }
            String customDelimiter = matcher.group(1);
            Matcher validator = Pattern.compile("[^0-9" + customDelimiter + "]").matcher(matcher.group(2));
            if (validator.find()) {
                throw new RuntimeException();
            }
            String[] tokens = matcher.group(2).split(customDelimiter);
            return Arrays.stream(tokens)
                    .mapToInt(Integer::parseInt)
                    .reduce(Integer::sum)
                    .orElseThrow(RuntimeException::new);
        }
        if ("".equals(operand)) {
            return 0;
        }
        Matcher validator = Pattern.compile("[^0-9,:]").matcher(operand);
        if (validator.find()) {
            throw new RuntimeException();
        }
        String[] tokens= operand.split("[,:]");
        return Arrays.stream(tokens)
                .mapToInt(Integer::parseInt)
                .reduce(Integer::sum)
                .orElseThrow(RuntimeException::new);
    }
}
