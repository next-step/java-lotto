package calculator;

public class Calculator {

    public static int calculate(String text) {
        if(text == null || text.isBlank()) throw new IllegalArgumentException("입력 값으로 null 또는 공백이 올수 없습니다");
        String[] values = text.split(" ");
        int result = Integer.parseInt(values[0]);

        for (int i = 1; i < values.length; i += 2) {
            String operator = values[i];
            int number = Integer.parseInt(values[i+1]);
            result = calculateResult(result, operator, number);
        }

        return result;
    }

    private static int calculateResult(int result, String operator, int number) {
        if (operator.equals("+")) {
            return add(result, number);
        }
        if(operator.equals("-")){
            return  subtract(result, number);
        }
        if (operator.equals("*")) {
            return  multiply(result, number);
        }
        if (operator.equals("/")) {
            return  divide(result, number);
        }

        throw new IllegalArgumentException("사칙 연산 기호가 입력되지 않았습니다.");
    }

    private static int add(int first, int second) {
        return first + second;
    }

    private static int subtract(int first, int second) {
        return first - second;
    }

    private static int multiply(int first, int second) {
        return first * second;
    }

    private static int divide(int first, int second) {
        return first / second;
    }

}
