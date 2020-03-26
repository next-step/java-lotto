package step1;

import java.util.List;

public class StringAddCalculator {
    public static int splitAndSum(String input) {
        int result = 0;

        if(ValidationUtils.isNullOrEmpty(input)) {
            result = 0;
        }
        else if(ValidationUtils.isOnlyNumber(input)) {
            result = Integer.parseInt(input);
        }
        else {
            String[] numbers = input.split(",");
            for (int i = 0; i < numbers.length; i++) {
                result = Integer.parseInt(numbers[i])+ result;
            }
        }
        return result;
    }
}
