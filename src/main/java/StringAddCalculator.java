public class StringAddCalculator {
    public static int splitAndSum(String input) {
        if (validateInput(input))
            return 0;

        return 1;
    }

    private static boolean validateInput(String input) {
        if (checkNull(input))
            return false;

        return !checkEmptyString(input);
    }

    private static boolean checkEmptyString(String input) {
        return input.isEmpty();
    }

    private static boolean checkNull(String input) {
        return input == null;
    }
}
