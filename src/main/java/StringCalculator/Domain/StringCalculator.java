package StringCalculator.Domain;

import java.util.Arrays;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class StringCalculator {

    private final List<Integer> input;

    public StringCalculator(String str) {
        this.input = split(str);
    }

    public StringCalculator(List<Integer> input) {
        this.input = input;
    }

    private static final String BASIC_SPLITTER = ("[,:]");
    private static final String CUSTOM_SPLITTER_PATTERN = ("//(.)\n(.*)");

    private List<Integer> split(String str) {
        validateEmptyString(str);
        List<String> strList = getStringList(str);
        validateListString(strList);

        return strList.stream().map(Integer::parseInt).collect(Collectors.toList());
    }

    public int sum() {
        return this.input.stream().mapToInt(Integer::intValue).sum();
    }

    private void validateListString(List<String> strList) {

        strList.forEach(str -> {
            int value = Integer.parseInt(str);
            if (value < 0) {
                throw new IllegalArgumentException("Input number cannot be negative");
            }
        });

    }

    private void validateEmptyString(String str) {
        if (str == null || str.isEmpty()) {
            throw new IllegalArgumentException("Input should not be null nor empty");
        }
    }

    private List<String> getStringList(String str) {

        Matcher m = Pattern.compile(CUSTOM_SPLITTER_PATTERN).matcher(str);
        if (m.find()) {
            String customDelimiter = m.group(1);
            String[] tokens = m.group(2).split(customDelimiter);
            return Arrays.asList(tokens);
        }

        return Arrays.asList(str.split(BASIC_SPLITTER));
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        StringCalculator that = (StringCalculator) o;

        return input != null ? input.equals(that.input) : that.input == null;
    }

    @Override
    public int hashCode() {
        return input != null ? input.hashCode() : 0;
    }
}
