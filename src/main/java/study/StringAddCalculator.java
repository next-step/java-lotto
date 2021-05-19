package study;

public class StringAddCalculator {
    private static final String DEFAULT_SEPARATOR = ",|:";
    private static final int MINIMUM_NUMBER = 0;
    private static final int ONE_SIZE_NUMBER = 1;

    public int splitAndSum(String input) {
        if ( !validateInput(input)) {
            return MINIMUM_NUMBER;
        }
        if (input.length() == ONE_SIZE_NUMBER) {
            return Integer.parseInt(input);
        }
        return sumNumbers(splitInput(input));
    }

    public boolean validateInput(String input) {
        if (input == null || input.isEmpty()) {
            return false;
        }
        return true;
    }

    public String[] splitInput(String input){
        return input.split(DEFAULT_SEPARATOR);
    }

    public int sumNumbers(String[] numbers) {
        int sum = 0;
        for (int i = 0; i < numbers.length; i++) {
            sum += Integer.parseInt(numbers[i]);
        }
        return sum;
    }
}
