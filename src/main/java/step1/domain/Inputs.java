package step1.domain;

import java.util.Objects;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Inputs {
    public static final Pattern EXTRACT_DELIMITERS_PATTERN = Pattern.compile("(?<=//).+(?=\n)");
    public static final Pattern EXTRACT_NUMBERS_PATTERN = Pattern.compile("(?<=\n).+");

    private final Delimiters delimiters;
    private final Numbers numbers;

    public Inputs(String input) {
        this.delimiters = isHaveDelimiters(input) ? extractDelimiters(input) : Delimiters.createWithoutInput();
        this.numbers = extractNumbers(input, delimiters);
    }

    private Delimiters extractDelimiters(String input) {
        Matcher matcher = EXTRACT_DELIMITERS_PATTERN.matcher(input);

        if (matcher.find()) {
            return Delimiters.createWithInput(new Delimiter(matcher.group(0)));
        }

        return null;
    }

    private Numbers extractNumbers(String input, Delimiters delimiters) {
        Matcher matcher = EXTRACT_NUMBERS_PATTERN.matcher(input);
        String extract = matcher.find() ? matcher.group(0) : input;

        return new Numbers(extract.split(delimiters.joining().getDelimiter()));
    }

    private boolean isHaveDelimiters(String input) {
        Matcher matcher = EXTRACT_DELIMITERS_PATTERN.matcher(input);

        return matcher.find();
    }

    public Number sum() {
        return numbers.sum();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Inputs inputs = (Inputs) o;
        return Objects.equals(delimiters, inputs.delimiters) &&
                Objects.equals(numbers, inputs.numbers);
    }

    @Override
    public int hashCode() {
        return Objects.hash(delimiters, numbers);
    }
}
