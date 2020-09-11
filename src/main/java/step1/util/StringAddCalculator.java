package step1.util;

public class StringAddCalculator {
    public static int splitAndSum(String input) {
        if(StringUtils.isNotBlank(input)) {
            return 0;
        }
        return Integer.parseInt(input.toString());
    }
}
