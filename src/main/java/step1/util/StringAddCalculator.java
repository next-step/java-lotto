package step1.util;

public class StringAddCalculator {
    public static int splitAndSum(String input) {
        if(StringUtils.isNotBlank(input)) {
            return 0;
        }
        if(StringUtils.isNumeric(input)) {
            return Integer.parseInt(input.toString());
        }
        return Integer.parseInt(input.toString());

    }
}
