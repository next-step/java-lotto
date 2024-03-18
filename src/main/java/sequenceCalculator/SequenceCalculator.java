package sequenceCalculator;

public class SequenceCalculator {

    public int calculate(String input) {
        if (input == null || input.isBlank()) {
            throw new IllegalArgumentException("null이나 빈 문자열은 들어올 수 없습니다.");
        }

        String[] split = input.split(" ");
        int result = 0;
        String operation = "+";
        for (int i = 0; i < split.length; i++) {
            if (ExpressionChecker.isDigit(split[i])) {
                switch (operation) {
                    case "+":
                        result += Integer.parseInt(split[i]);
                        break;
                    case "-":
                        result -= Integer.parseInt(split[i]);
                        break;
                    case "*":
                        result *= Integer.parseInt(split[i]);
                        break;
                    case "/":
                        result /= Integer.parseInt(split[i]);
                        break;
                }
                continue;
            }
            if (ExpressionChecker.isBasicOperation(split[i])) {
                operation = split[i];
            }
        }

        return result;
    }

}
