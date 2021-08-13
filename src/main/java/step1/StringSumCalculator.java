package step1;

public class StringSumCalculator {

    public int sum(String inputText) {

        if (inputText == null || inputText.trim().isEmpty()) {
            return 0;
        }

        int result = 0;
        String[] inputNumbers = inputText.split(",|:");

        for (String inputNumber : inputNumbers) {
            result += Integer.parseInt(inputNumber);
        }
        return result;
    }

}
