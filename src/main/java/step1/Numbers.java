package step1;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class Numbers {
    private static final String CUSTOM_PATTERN = "//(.)\n(.*)";
    private final List<Number> numbers;

    public Numbers(List<Number> numbers) {
        this.numbers = numbers;
    }

    public static Numbers of(String str) {
        if (hasCustomDelimiter(str)) {
            return new Numbers(exportCustomDelimiterNumbers(str));
        }
        return new Numbers(exportSplitNumbers(str));
    }

    public static List<Number> exportSplitNumbers(String str) {
        String[] str2 = str.split(",|:");
        return Arrays.stream(str2)
                .map(Number::new)
                .collect(Collectors.toList());
    }

    public static List<Number> exportCustomDelimiterNumbers(String str) {
        Matcher matcher = Pattern.compile(CUSTOM_PATTERN).matcher(str);
        if (matcher.find()) {
            String customDelimiter = matcher.group(1);
            String[] tokens = matcher.group(2).split(customDelimiter);
            return Arrays.stream(tokens)
                    .map(Number::new)
                    .collect(Collectors.toList());
        }
        return new ArrayList<>();
    }

    private static boolean hasCustomDelimiter(String str) {
        return str.contains("//");
    }

    public int sum() {
        return numbers.stream()
                .mapToInt(Number::getNumber)
                .sum();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Numbers numbers1 = (Numbers) o;
        return Objects.equals(numbers, numbers1.numbers);
    }

    @Override
    public int hashCode() {
        return Objects.hash(numbers);
    }
}
