package stringcalculator;

public class StringAddCalculator {

    public int splitAndSum(String input) {
        int result = 0;

        if (input == null) {
            result = 0;
        }

        if (input.isEmpty()) {
            result = 0;
        }

        if ((input.charAt(0) >= 49 && input.charAt(0) <= 57) && input.length() == 1) {
            result = Integer.parseInt(input);
        }

        return result;
    }
}
