package step1;

public class StringSumCalculator {

    public int sum(final String inputText) {

        if (inputText == null || inputText.trim().isEmpty()) {
            return 0;
        }

        return splitAndSum(inputText);
    }

    private int splitAndSum(final String inputText) {
        int result = 0;
        String[] inputNumbers = inputText.split(",|:");

        for (String inputNumber : inputNumbers) {
            result += Integer.parseInt(inputNumber);
        }
        return result;
    }

}
