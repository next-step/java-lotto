package pluscalculator;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class FomularFactory {
    private static final String REGEX = "//(.)\n(.*)";

    public static FomularInterface getInstance(String input) {
        if (input == null || input.isEmpty()) {
            return new EmptyFomular();
        }

        Matcher m = Pattern.compile(REGEX).matcher(input);

        if (m.find()) {
            return new CustomFomular(m);
        }

        return new NormalFomular();
    }
}
