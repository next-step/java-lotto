package step1.algorithm;

public class CalculationCache {
    private static class SingletonHelper {
        private static final Calculable CALCULABLE_USING_DELIMITER = new CalculableUsingDelimiter();
    }

    public static Calculable getCalculateUsingDelimiter() {
        return SingletonHelper.CALCULABLE_USING_DELIMITER;
    }
}
