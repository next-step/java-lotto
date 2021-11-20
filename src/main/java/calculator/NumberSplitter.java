package calculator;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class NumberSplitter {

    private final List<String> separators = Arrays.asList(",", ":");

    public List<Number> split(String target) {
        List<String> numbers = Collections.singletonList(target);
        for (String separator : separators) {
            numbers = splitByOneSeparator(numbers, separator);
        }
        return numbers.stream()
                .map(Number::new)
                .collect(Collectors.toList());
    }

    private List<String> splitByOneSeparator(List<String> targets, String separator) {
        List<String> results = new ArrayList<>();
        for (String target : targets) {
            String[] numbers = target.split(separator);
            results.addAll(
                    Arrays.asList(numbers));
        }
        return results;
    }
}
