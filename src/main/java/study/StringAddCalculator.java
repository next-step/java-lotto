package study;

import java.util.List;

public class StringAddCalculator {

    private StringAddCalculator() {}

    public static int splitAndSum(String text) {
        if (StringUtil.isNullOrEmpty(text)) {
            return 0;
        }

        if (StringUtil.isSingleWord(text)) {
            return Integer.parseInt(text);
        }

        List<Integer> numbers = getNumbers(text);
        checkNegative(numbers);
        return sum(numbers);
    }

    private static List<Integer> getNumbers(String text) {
        String[] tokens = StringSplitter.split(text);
        return IntegerUtil.parseArray(tokens);
    }

    private static Integer sum(List<Integer> numbers) {
        return numbers.stream()
                .reduce(0, Integer::sum);
    }

    private static void checkNegative(List<Integer> numbers) {
        numbers.stream()
                .filter(n -> n < 0)
                .findAny()
                .ifPresent(t -> {throw new RuntimeException();});
    }
}
