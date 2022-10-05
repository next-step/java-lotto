package stringCalculator.validator;

import java.util.Objects;
import java.util.regex.Pattern;

public class MathEquationValidator {

    private static final Pattern MATH_EQUATION_PATTERN = Pattern.compile("^[+\\-*/\\d\\s]*$");
    public static void validate(String mathEquation) {
        if (Objects.isNull(mathEquation) || mathEquation.isEmpty() || mathEquation.isBlank()) {
            throw new IllegalArgumentException("mathEquation is empty");
        }

        if (!MATH_EQUATION_PATTERN.matcher(mathEquation).matches()) {
            throw new IllegalArgumentException(String.format("mathEquation has wrong word : %s", mathEquation));
        }
    }
}
