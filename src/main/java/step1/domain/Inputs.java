package step1.domain;

import java.util.Objects;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Inputs {
    public static final Pattern EXTRACT_DELIMITER_PATTERN = Pattern.compile("(?<=//).+(?=\n)");

    private final Delimiters delimiters;
    private final Numbers numbers;

    private Inputs(Delimiters delimiters, Numbers numbers) {
        this.delimiters = delimiters;
        this.numbers = numbers;
    }

    public static Inputs createWithDelimiters(String input) {
        Delimiter extractDelimiter = extractDelimiters(input);
        Numbers extractNumbers = Delimiters.createWithDelimiter(extractDelimiter).split(input);

        return new Inputs(Delimiters.createWithDelimiter(extractDelimiter), extractNumbers);
    }

    public static Inputs createWithoutDelimiters(String input) {
        Delimiters delimiters = Delimiters.createWithoutDelimiter();
        return new Inputs(Delimiters.createWithoutDelimiter(), delimiters.split(input));
    }

    private static Delimiter extractDelimiters(String input) {
        Matcher matcher = EXTRACT_DELIMITER_PATTERN.matcher(input);
        return new Delimiter(matcher.group(0));
    }

    public static boolean isHaveDelimiters(String input) {
        Matcher matcher = EXTRACT_DELIMITER_PATTERN.matcher(input);
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
