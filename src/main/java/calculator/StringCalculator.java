package calculator;

public class StringCalculator {
    public int calc(String input) {
        String[] parsed = input.split(" ");

        int result = Integer.parseInt(parsed[0]);

        for (int i = 1; i < parsed.length; i += 2) {
            String operation = parsed[i];
            int target = Integer.parseInt(parsed[i + 1]);
            switch (operation) {
                case "+":
                    result += target;
                    break;
                case "-":
                    result -= target;
                    break;
                case "/":
                    result /= target;
                    break;
                case "*":
                    result *= target;
                    break;
                default:
                    throw new IllegalArgumentException("사칙연산자가 아닙니다.");
            }
        }

        return result;
    }
}
