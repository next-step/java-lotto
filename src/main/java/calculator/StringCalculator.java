package calculator;

public class StringCalculator {

    public int calculator(String input) {
        if (input == null || input.trim().isBlank()) {
            throw new IllegalArgumentException("입력값이 null이거나 공백문자인 경우 계산되지 않습니다.");
        }

        String[] inputSplit = input.split(" ");
        int result = Integer.parseInt(inputSplit[0]);

        for (int i = 1; i < inputSplit.length; i += 2) {
            String operator = inputSplit[i];
            int number = Integer.parseInt(inputSplit[i + 1]);


            if (operator.equals("+")) {
                result += number;
                continue;
            }
            if (operator.equals("-")) {
                result -= number;
                continue;
            }
            if (operator.equals("*")) {
                result *= number;
                continue;
            }
            if (operator.equals("/")) {
                result /= number;
                continue;
            }
            throw new IllegalArgumentException("사칙연산 기호가 아닐 경우에는 계산되지 않습니다.");
        }
        return result;
    }
}
