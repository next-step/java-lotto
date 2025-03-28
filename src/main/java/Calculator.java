class Calculator {
    private static void validateInput(String expression) {
        if (expression == null || expression.isBlank()) {
            throw new IllegalArgumentException("입력 값이 null이거나 빈 공백 문자입니다.");
        }
    }

    static int run(String expression) {
        validateInput(expression);

        String[] tokens = expression.split(" ");

        int result = Integer.parseInt(tokens[0]);
        int i = 1;
        while (i < tokens.length - 1) {
            Operator operator = Operator.fromSymbol(tokens[i]);
            int operand = Integer.parseInt(tokens[i+1]);
            result = operator.calculate(result, operand);
            i += 2;
        }

        return result;
    }
}
