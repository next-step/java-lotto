package calculator;

class StringCalculator {
    public int calc(String input) {
        String[] parsed = input.split(" ");

        int result = Integer.parseInt(parsed[0]);

        for (int i = 1; i < parsed.length; i += 2) {
            StringOperator operator = StringOperator.of(parsed[i]);
            int target = Integer.parseInt(parsed[i + 1]);

            switch (operator) {
                case ADD:
                    result += target;
                    break;
                case SUB:
                    result -= target;
                    break;
                case DIV:
                    result /= target;
                    break;
                case MUL:
                    result *= target;
                    break;
                default:
                    throw new IllegalArgumentException("사칙연산자가 아닙니다.");
            }
        }

        return result;
    }
}
