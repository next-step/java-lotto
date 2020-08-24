package domain;

import java.util.Arrays;

public class InputValue {
    public static int inputValueValidate(String inputValue) {
        if(inputValue == null)
            return 0;
        if(inputValue.isEmpty())
            return 0;

        String[] numbers = inputValue.split(",");
        return sum(numbers);
    }

    private static int sum(String[] numbers) {
        return Arrays.stream(numbers).mapToInt(Integer::parseInt).sum();
    }

}
