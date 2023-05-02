package calculator.domain;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class StringCalculator {
    public static List<String> devide(String input) {
        return Arrays.stream(input.trim().split(" ")).collect(Collectors.toList());
    }
}
