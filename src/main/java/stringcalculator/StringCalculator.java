package stringcalculator;

public class StringCalculator {

    public int sum(String input) {
        if (input == null || input.isEmpty()) {
            return 0;
        }

        String[] inputSplits = input.split(",");
        int result = 0;
        for (String inputSplit : inputSplits) {
            result += Integer.parseInt(inputSplit);
        }

        return result;
    }
}
