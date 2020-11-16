package step01;

import java.util.Arrays;

public class StringAddCalculator {
    public static String tokens = ",|:";

    public static int splitAndSum(String input) {
        if (input == null || input.trim() == "") {
            return 0;
        }

        try {
            return Integer.parseInt(input);
        } catch (Exception exception) {

        }

        return Arrays.stream(input.split(tokens))
                .mapToInt(Integer::parseInt)
                .reduce(0, (a, b) -> a + b);



    }
}
