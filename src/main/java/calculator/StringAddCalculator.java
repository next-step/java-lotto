package calculator;

public class StringAddCalculator {

    public static int splitAndSum(String calculationText) {

        if (validate(calculationText)) {
            return 0;
        }
        return Integer.parseInt(calculationText);
    }

    private static boolean validate(String calculationText) {
        return calculationText == null || calculationText.isEmpty();
    }

}
