package calculator;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class StringAddCalculator {
    private final static int ZERO = 0;
    public static int splitAndSum(String text) {
        int result = ZERO;
        if(text == null) return ZERO;
        if(text.isEmpty()) return ZERO;

        List<Integer> numbers;
        Matcher matcher = Pattern.compile("//(.)\n(.*)").matcher(text);
        if (matcher.find()) {
            String customDelimiter = matcher.group(1);
            String[] tokens= matcher.group(2).split(customDelimiter);
            numbers = Arrays.stream(tokens).map(Integer::parseInt).collect(Collectors.toList());
            // 덧셈 구현
            result = numbers.stream().mapToInt(Integer::intValue).sum();
        } else {
            String[] numberStrs = text.split(",|:");
            numbers = Arrays.stream(numberStrs).map(Integer::parseInt).collect(Collectors.toList());
            result = numbers.stream().mapToInt(Integer::intValue).sum();
        }
        Optional<Integer> any = numbers.stream().filter(it -> it < 0).findAny();
        if(any.isPresent()) throw new RuntimeException();

        if(numbers.size() == 1) {
            result = numbers.get(0);
        }
        return result;
    }
}
