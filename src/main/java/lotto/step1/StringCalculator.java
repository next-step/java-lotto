package lotto.step1;

import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringCalculator {

    private static final String BASIC_DELIMITER_PATTERN = "[,:]";
    private static final String CUSTOM_DELIMITER_PATTERN = "//(.)\n(.*)";

    private List<String> values;

    public StringCalculator(String input) {
        String[] array = splitDelimiter(input);
        this.values = Arrays.asList(array);
    }

    public List<String> getValues() {
        return values;
    }

    public int add() {
        return values.stream()
                .mapToInt(Integer::valueOf)
                .sum();
    }

    private String[] splitDelimiter(String input) {
        Matcher m = Pattern.compile(CUSTOM_DELIMITER_PATTERN).matcher(input);
        if (m.find()) {
            String customDelimiter = m.group(1);
            return m.group(2).split(customDelimiter);
        }
        return input.split(BASIC_DELIMITER_PATTERN);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        StringCalculator that = (StringCalculator) o;
        return Objects.equals(values, that.values);
    }

    @Override
    public int hashCode() {
        return Objects.hash(values);
    }

}
