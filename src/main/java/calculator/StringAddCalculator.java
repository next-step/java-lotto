package calculator;


public class StringAddCalculator {

    public int plus(String input) {
        if (isNullOrEmpty(input)) {
            return 0;
        }
        return getSum(getSplitString(input));
    }

    private String[] getSplitString(String input) {
        return input.split("[,:]");
    }

    private boolean isNullOrEmpty(String input) {
        return input == null || input.replaceAll(" ", "").isEmpty();
    }

    private int getSum(String[] numbers) {
        int sum = 0;

        for (String number : numbers) {
            sum += Integer.parseInt(number);
        }
        return sum;
    }
}
