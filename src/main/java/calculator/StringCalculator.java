package calculator;

import java.util.stream.Stream;

public class StringCalculator {
    public int splitAndSum(String string) {
        if (string == null | string == "") {
            return 0;
        }

        return Stream.of(string.split(":|,")).mapToInt(Integer::parseInt).sum();
    }
}
