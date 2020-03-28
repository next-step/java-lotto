package Calculator;

public class StringAddCalculator {
    static private final String DELIMITER = ",|:";

    public static int splitAndSum(final String inputString) {
        if (!validateInputString(inputString)) {
            return 0;
        }
        return AddNumber.newInstance(inputString.split(DELIMITER)).add();
    }

    private static boolean validateInputString(final String inputString) {
        return inputString != null && !inputString.isEmpty();
    }
}
