public class StringAddCalculator {

    public static final String EMPTY_STRING = "";
    public static final String DELIMITER = ",";

    public static int splitAndSum(String formula) {
        if (isNullOrEmpty(formula)) {
            return 0;
        }

        String[] numbers = split(formula);
        int sum = 0;
        for (String number : numbers) {
            sum += Integer.parseInt(number);
        }

        return sum;
    }

    private static String[] split(String formula) {
        return formula.split(DELIMITER);
    }

    private static boolean isNullOrEmpty(String formula) {
        return formula == null || EMPTY_STRING.equals(formula);
    }
}
