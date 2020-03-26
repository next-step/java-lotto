package step1;

public class StringAddCalculator {
    public static int splitAndSum(String input) {
        int result = 1;

        if(ValidationUtils.isNullOrEmpty(input)) {
            result = 0;
        }
        return result;
    }
}
