package stringcalculator.domain;

public class StringCalculator {

    public static final String SPACE = " ";
    private final String expression;

    public StringCalculator(String expression) {
        this.expression = expression;
        validateExpression();
    }

    public StringCalculator() {
        expression = null;
    }

    private void validateExpression() {
        String[] elements = expression.split(SPACE);


        throw new IllegalArgumentException("계산식의 형식이 맞지 않습니다.");
    }

    public int add(int x, int y) {
        return x + y;
    }

    public int subtract(int x, int y) {
        return x - y;
    }

    public int multiply(int x, int y) {
        return x * y;
    }

    public int divide(int x, int y) {
        return x / y;
    }

//    public int reduce() {
//        int result = Integer.parseInt(elements[0]);
//        for (int i = 1; i < elements.length; i++) {
//
//        }
//
//        return result;
//    }

    private int forEach(String[] elements, int result, int i) {
        if (elements[i].matches("\\d*\\.?\\d+")) {
            switch (elements[i - 1]) {
                case "+":
                    result = add(result, Integer.parseInt(elements[i]));
                    break;
                case "-":
                    result = subtract(result, Integer.parseInt(elements[i]));
                    break;
                case "*":
                    result = multiply(result, Integer.parseInt(elements[i]));
                    break;
                case "/":
                    result = divide(result, Integer.parseInt(elements[i]));
                    break;
            }
        }
        return result;
    }
}
