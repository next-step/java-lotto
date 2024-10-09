package calculator;

public class StringCalculator {

    public int calculator(String input) {
        String[] inputSplit = input.split(" ");
        int result = Integer.parseInt(inputSplit[0]);

        for (int i = 1; i < inputSplit.length; i += 2) {
            String operator = inputSplit[i];
            int number = Integer.parseInt(inputSplit[i + 1]);

            if (operator.equals("+")) {
                result += number;
            }
        }
        return result;
    }
}
