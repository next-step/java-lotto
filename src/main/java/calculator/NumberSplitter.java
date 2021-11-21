package calculator;

import java.util.*;
import java.util.stream.Collectors;

public class NumberSplitter {

    private static final List<String> DEFAULT_SEPARATORS = Arrays.asList(",", ":");

    private final List<String> separators;

    public NumberSplitter(String separator) {
        this();
        if (!Objects.isNull(separator) && !separator.isEmpty()) {
            this.separators.add(separator);
        }
    }

    public NumberSplitter() {
        this.separators = new ArrayList<>(DEFAULT_SEPARATORS);
    }

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
