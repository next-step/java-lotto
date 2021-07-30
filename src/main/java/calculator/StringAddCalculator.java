package calculator;

import java.util.Arrays;

public class StringAddCalculator {

    public int calculate(String input) {
        if (input.isEmpty() || input == null) {
            return 0;
        }

        if (input.length() == 1) {
            return Integer.parseInt(input);
        }

        String[] numbers = getNumbers(input);

        int result = sum(numbers);

        return result;
    }

    private Integer sum(String[] numbers) {
        Integer result;
        result = Arrays.stream(numbers)
                .mapToInt(Integer::parseInt)
                .sum();
        return result;
    }

    private String[] getNumbers(String input) {
        if(input.contains("//") && input.contains("\\n")){
            String prefix = input.substring(0, 5);
            String suffix = input.substring(5, input.length());

            String slashRemoveString = prefix.replace("//", "");
            String delimiter = slashRemoveString.replace("\\n", "");

            return suffix.split(delimiter);
        }
        return input.split(",|:");
    }
}
