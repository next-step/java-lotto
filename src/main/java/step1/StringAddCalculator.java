package step1;

public class StringAddCalculator {
    public static int splitAndSum(String input) {
        int result = 1;

        if(ValidationUtils.isNullOrEmpty(input)) {
            result = 0;
        }
        else if(input.matches("^[0-9]*$")) {
            result = Integer.parseInt(input);
        }

        return result;
    }
}
