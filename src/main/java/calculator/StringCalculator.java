package calculator;

public class StringCalculator {

    public int calculator(String input) {
        if (input == null || input.trim().isBlank()) {
            throw new IllegalArgumentException("빈 공백 문자는 계산되지 않습니다.");
        }

        String[] inputSplit = input.split(" ");
        int result = Integer.parseInt(inputSplit[0]);

        for (int i = 1; i < inputSplit.length; i += 2) {
            String operator = inputSplit[i];
            int number = Integer.parseInt(inputSplit[i + 1]);

            if (operator.equals("+")) {
                result += number;
            }
            if (operator.equals("-")) {
                result -= number;
            }
            if (operator.equals("*")) {
                result *= number;
            }
            if (operator.equals("/")) {
                result /= number;
            }
        }
        return result;
    }
}
