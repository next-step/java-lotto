package calculator;

public class StringCalculator {

    public int calculator(String input) {
        validationInput(input);

        String[] inputSplit = input.split(" ");
        int result = Integer.parseInt(inputSplit[0]);

        for (int i = 1; i < inputSplit.length; i += 2) {
            String operator = inputSplit[i];
            int number = Integer.parseInt(inputSplit[i + 1]);

            result = solve(operator, result, number);
            continue;
        }
        return result;
    }

    private static int solve(String operator, int result, int number) {
        if (operator.equals("+")) {
            return result + number;
        }

        if (operator.equals("-")) {
            return result - number;
        }

        if (operator.equals("*")) {
            return result * number;
        }

        if (operator.equals("/")) {
            return result / number;
        }

        throw new IllegalArgumentException("사칙연산 기호가 아닐 경우에는 계산되지 않습니다.");
    }

    private static void validationInput(String input) {
        if (input == null || input.trim().isBlank()) {
            throw new IllegalArgumentException("입력값이 null이거나 공백문자인 경우 계산되지 않습니다.");
        }
    }
}
