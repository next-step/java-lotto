package step1.domain;

import java.util.Objects;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Inputs {
    public static final Pattern EXTRACT_DELIMITERS_PATTERN = Pattern.compile("(?<=//).+(?=\n)");
    public static final Pattern EXTRACT_NUMBERS_PATTERN = Pattern.compile("(?<=\n).+");

    private final Delimiters delimiters;
    private final Numbers numbers;

    private Inputs(Delimiters delimiters, Numbers numbers) {
        this.delimiters = delimiters;
        this.numbers = numbers;
    }

    public static Inputs create(String input) {
        if (isHaveDelimiters(input)) {
            return createWithDelimiters(input);
        }

        return createWithoutDelimiters(input);
    }

    private static Inputs createWithDelimiters(String input) {
        Delimiters delimiters = extractDelimiters(input);
        Numbers numbers = extractNumbers(input, delimiters);

        return new Inputs(delimiters, numbers);
    }

    private static Inputs createWithoutDelimiters(String input) {
        Delimiters delimiters = Delimiters.createWithoutInput();
        Numbers numbers = extractNumbers(input, delimiters);

        return new Inputs(delimiters, numbers);
    }

    private static Delimiters extractDelimiters(String input) {
        Matcher matcher = EXTRACT_DELIMITERS_PATTERN.matcher(input);

        if (matcher.find()) {
            return Delimiters.createWithInput(new Delimiter(matcher.group(0)));
        }

        return null;
    }

    private static Numbers extractNumbers(String input, Delimiters delimiters) {
        Matcher matcher = EXTRACT_NUMBERS_PATTERN.matcher(input);
        String extract = matcher.find() ? matcher.group(0) : input;

        return new Numbers(extract.split(delimiters.joining()));
    }

    public static boolean isHaveDelimiters(String input) {
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
