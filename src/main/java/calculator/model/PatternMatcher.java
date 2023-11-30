package calculator.model;

import java.util.regex.Pattern;

public class PatternMatcher {

    private static final String OPERATIONS = "^[0-9+\\-*/\\d]*$";
    private static final Pattern PATTERN = Pattern.compile(OPERATIONS);


    public static boolean validate(String text) {
        return PATTERN.matcher(text).find();
    }
}
