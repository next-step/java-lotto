package calculator;

import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class Numbers {
    private static final String DEFAULT_DELIMITER_REGEX = "[,:]";
    private static final Pattern CUSTOM_DELIMITER_PATTERN = Pattern.compile("//(.)\n(.*)");
    private static final int DELIMITER_GROUP_INDEX = 1;
    private static final int NUMBERS_GROUP_INDEX = 2;
    private static final String ZERO = "0";


    private final List<Number> numbers;

    public Numbers(String text) {
        this.numbers = textToNumbers(text);
    }

    private List<Number> textToNumbers(String text) {
        Matcher m = CUSTOM_DELIMITER_PATTERN.matcher(text);
        if (m.find()) {
            String customDelimiter = m.group(DELIMITER_GROUP_INDEX);
            return Arrays.stream(m.group(NUMBERS_GROUP_INDEX).split(customDelimiter)).map(Number::new).collect(Collectors.toList());
        }
        return Arrays.stream(text.split(DEFAULT_DELIMITER_REGEX)).map(Number::new).collect(Collectors.toList());
    }

    public Number sum() {
        return this.numbers.stream().reduce(Number::add).orElse(new Number(ZERO));
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
