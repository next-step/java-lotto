public class StringCalculator {

    public static int calculator(String text) {

        if (isNullOrEmpty(text)) {
            throw new IllegalArgumentException("문자열을 입력해주세요.");
        }

        String[] token = splitedToken(text);

        return calculateToken(token);
    }

    private static boolean isNullOrEmpty(String text) {
        return text == null || text.isEmpty();
    }

    private static String[] splitedToken(String text) {
        return text.split(" ");
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

        Calculator calculator = Calculator.from(selectOperator(operator));
        return calculator.calculate(firstNumber, secondNumber);
    }

    private static Operator selectOperator(String operator) {
        if (operator.equals("+")) {
            return new PlusOperator();
        }

        if (operator.equals("-")) {
            return new MinusOperator();
        }

        if (operator.equals("/")) {
            return new DevideOperator();
        }

        if (operator.equals("*")) {
            return new MultipleOperator();
        }

        throw new IllegalArgumentException("유효한 사칙연산 기호를 입력해주세요.");
    }
}
