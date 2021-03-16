package StringCalculator;

import java.util.Objects;

public class StringAddCalculator {

    private StringAddCalculator() { }

    public static boolean isEmpty(String value) {
        return Objects.isNull(value) || value.trim().isEmpty();
    }

    public static String[] split(String value) {
        return StringSplitter.getStrings(value);
    }

    public static int splitAndSum(String value) throws RuntimeException {
        if (isEmpty(value))
            return 0;
        return new Numbers(split(value)).sum();
    }
}
