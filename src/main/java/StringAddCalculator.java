public class StringAddCalculator {
    public static int splitAndSum(String formula) {
        if (isNullOrEmpty(formula))
            return 0;
        return Integer.parseInt(formula);
    }

    private static boolean isNullOrEmpty(String formula) {
        return formula == null || "".equals(formula);
    }
}
