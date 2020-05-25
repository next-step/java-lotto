package step1;

public class StringAddCalculator {

    public static int splitAndSum(String numberString) {
        if (!validateText(numberString)) {
            return 0;
        }
        int result = Integer.parseInt(numberString);

        return result;
    }

    private static Boolean validateText(String numberString) {
        if (numberString == null) {
            return false;
        }
        if (numberString.isEmpty()) {
            return false;
        }

        return true;
    }
}
