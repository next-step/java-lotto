package stringcalculator;

public class StringAddCalculator {

    public int splitAndSum(String input) {
        int result = 0;

        if (isInValidation(input)) {
            return 0;
        }

        if ((input.charAt(0) >= 49 && input.charAt(0) <= 57) && input.length() == 1) {
            return Integer.parseInt(input);
        }

        String[] data = input.split(",");
        result = Integer.parseInt(data[0]);

        for (int i = 1; i < data.length; i+=2) {
               result += Integer.parseInt(data[i]);
        }

        return result;
    }

    public boolean isInValidation(String input) {
        return input == null || input.isEmpty();
    }
}
