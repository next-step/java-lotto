public class Calculator {
    private static void validate_input(String expression) {
        if (expression == null || expression.isBlank()) {
            throw new IllegalArgumentException("입력 값이 null이거나 빈 공백 문자입니다.");
        }
    }

    private static int updateResult(int result, Operand operand, int number) {
        if (operand == null) {
            return number;
        } 
        else {
            return operand.operate(result, number);
        }
    }

    public static int run(String expression) {
        validate_input(expression);

        int result = 0;
        Operand operand = null;

        String[] tokens = expression.split(" ");
        for (int i = 0; i < tokens.length; i++) {
            String t = tokens[i];
            if (i % 2 == 0) {
                int number = Integer.parseInt(t);
                result = updateResult(result, operand, number);
            }
            else {
                operand = new Operand(t);
            }
        }

        return result;
    }
}
