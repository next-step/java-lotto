public class StringCalculator {

    public static int calculator(String text) {

        if (isNullOrEmpty(text)) {
            throw new IllegalArgumentException("문자열을 입력해주세요.");
        }

        String[] token = splitedToken(text);

        return calculateToken(token);
    }

    private static int calculateToken(String... token) {
        for (int i = 0; i < token.length - 1; i += 2) {
            String[] part = {token[i], token[i + 1], token[i + 2]};
            token[i + 2] = String.valueOf(calcuatePartOfToken(part));
        }

        return Integer.parseInt(token[token.length - 1]);
    }

    private static int calcuatePartOfToken(String... token) {
        int firstNumber = Integer.parseInt(token[0]);
        String operator = token[1];
        int secondNumber = Integer.parseInt(token[2]);

        Calculator calculator = new Calculator(selectCommand(operator));
        return calculator.calculate(firstNumber, secondNumber);
    }

    private static Command selectCommand(String operator) {
        if (operator.equals("+")) {
            return new PlusCommand();
        }

        if (operator.equals("-")) {
            return new MinusCommand();
        }

        if (operator.equals("/")) {
            return new DevideCommand();
        }

        if (operator.equals("*")) {
            return new MultipleCommand();
        }

        throw new IllegalArgumentException("유효한 사칙연산 기호를 입력해주세요.");
    }

    private static boolean isNullOrEmpty(String text) {
        return text == null || text.isEmpty();
    }

    private static String[] splitedToken(String text) {
        return text.split(" ");
    }
}
