package calculator.model;

import calculator.exception.NotNaturalNumberException;

import java.util.regex.Pattern;

import static java.lang.Integer.parseInt;

public class NaturalNumber {
    private static final Pattern NATURAL_NUMBER_PATTERN = Pattern.compile("\\d+");

    public static final int ZERO = 0;

    private NaturalNumber() {
    }

    public static Integer parseNaturalNumber(String naturalNumber) {
        validate(naturalNumber);
        return parseInt(naturalNumber);
    }

    private static void validate(String naturalNumber) {
        if (!NATURAL_NUMBER_PATTERN.matcher(naturalNumber).matches()) {
            throw new NotNaturalNumberException();
        }
    }
}
