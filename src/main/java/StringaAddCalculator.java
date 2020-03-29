public class StringaAddCalculator {

    public static int splitAndSum(String formula) {
        if (isNotEmpty(formula)) {
            return 0;
        }

        return 1;
    }

    private static boolean isNotEmpty(String formula) {
        return formula != null || !"".equals(formula);
    }
}
