package calculator;

public class StringAddCalculator {

    public static void main(String[] args) {

    }

    public static int splitAndSum(String input) {

        if (checkNullOrEmptyString(input)) {
            return 0;
        }

        return 0;
    }

    public static boolean checkNullOrEmptyString(String input) {

        if (input == null || input.length() == 0) {
            return true;
        }

        return false;
    }

}
