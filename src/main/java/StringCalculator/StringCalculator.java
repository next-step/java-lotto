package StringCalculator;

import java.util.List;

public class StringCalculator {
    private final static String SPLIT_PATTERN = " ";
    private final static String NUMBER_PATTERN = "^[0-9]+$";
    private final static int INDEX_FIRST = 0;
    private final static int INDEX_SECOND = 1;

    public static int calculate(String input) {
        if (IsNull(input)) {
            throw new IllegalArgumentException();
        }

        return splitAndOperating(input);
    }

    private static boolean IsNull(String input) {
        if (input == null || "".equals(input)) {
            return true;
        }

        return false;
    }

    private static int splitAndOperating(String input) {
        List<String> inputs = List.of(input.split(SPLIT_PATTERN));

        int sum = Integer.valueOf(inputs.get(INDEX_FIRST));
        for (int index = INDEX_SECOND; index < inputs.size(); index++) {
            sum = getSum(sum, inputs, index);
        }

        return sum;
    }

    private static int getSum(int sum, List<String> inputs, int index) {
        if (inputs.get(index).matches(NUMBER_PATTERN)) {
            return Operation.operating(sum, inputs.get(index - 1), Integer.valueOf(inputs.get(index)));
        }

        return sum;
    }

}
