package stringaddcalculator;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class StringSpliter {

    private StringMatcher stringMatcher;

    private StringSpliter(String text) {
        validate(text);
        this.stringMatcher = StringMatcher.of(text);
    }

    private void validate(String text) {
        if (text == null) {
            throw new IllegalArgumentException("Text is null");
        }
    }

    public static StringSpliter of(String text) {
        return new StringSpliter(text);
    }

    public List<Integer> split() {
        String delimeter = stringMatcher.getDelimeter();
        String numbers = stringMatcher.getNumbers();

        return Stream.of(numbers.split(delimeter))
                .map(Integer::parseInt)
                .collect(Collectors.toList());
    }
}
