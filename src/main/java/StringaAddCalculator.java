public class StringaAddCalculator {

    public static int splitAndSum(String formula) {
        if (isNullOrEmpty(formula)) {
            return 0;
        }

        return 1;
    }

    private static boolean isNullOrEmpty(String formula) {
        return formula == null || "".equals(formula);
    }
}
