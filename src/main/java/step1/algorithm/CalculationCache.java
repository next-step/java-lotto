package step1.algorithm;

import step1.util.PatternCache;

import java.util.regex.Pattern;

public class CalculationCache {
    private static class SingletonHelper{
        private static final Calculate CALCULATE_USING_DELIMITER = new CalculateUsingDelimiter();
    }

    public static Calculate getCalculateUsingDelimiter() {
        return SingletonHelper.CALCULATE_USING_DELIMITER;
    }
}
