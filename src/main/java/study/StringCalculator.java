package study;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class StringCalculator {

    public static final String OPERATOR_REGEX = " \\+ | \\- | \\* | \\/ ";
    public static final String NUMBER_REGEX = "[0-9]+";

    public static int calc(String input) {
        int result = 0;

        List<Integer> integers = extractNumbers(input);
        List<String> operators = extractOperators(input);

        if (integers.isEmpty()) {
            return result;
        }

        result = integers.get(0);
        for (int i = 1; i < integers.size(); i++) {
            String op = operators.get(i - 1);
            int nextNumber = integers.get(i);

            if (op.equals(" + ")) {
                result += nextNumber;
            } else if (op.equals(" - ")) {
                result -= nextNumber;
            } else if (op.equals(" * ")) {
                result *= nextNumber;
            } else if (op.equals(" / ")) {
                result /= nextNumber;
            }
        }

        return result;
    }

    public static List<String> extractOperators(String input) {
        String[] split2 = input.split(NUMBER_REGEX);
        return Arrays.stream(split2)
                .filter(s -> !s.equals(""))
                .collect(Collectors.toList());
    }

    public static List<Integer> extractNumbers(String input) {
        return Arrays.stream(input.split(OPERATOR_REGEX))
                .map(Integer::parseInt)
                .collect(Collectors.toList());
    }
}
