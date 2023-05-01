package stringcalculator;


public class StringCalculator {

    public int calculateString(String input) {
        String[] separatedString = StringUtil.splitString(input);
        int result = Integer.parseInt(separatedString[0]);

        for (int i = 0; i < separatedString.length - 2; i += 2) {
            result = calculate(result, separatedString[i + 1].charAt(0), Integer.parseInt(separatedString[i + 2]));
        }

        return result;
    }

    private int calculate(int firstOperand, Character operator, int secondOperand) {
        if (operator == '+') {
            return add(firstOperand, secondOperand);
        }
        if (operator == '-') {
            return subtract(firstOperand, secondOperand);
        }
        if (operator == '*') {
            return multiply(firstOperand, secondOperand);
        }
        if (operator == '/') {
            return divine(firstOperand, secondOperand);
        }
        throw new IllegalArgumentException("4칙 연산자가 아닌 문자가 입력되었습니다.");
    }

    private int add(int a, int b) {
        return a + b;
    }

    private int subtract(int a, int b) {
        return a - b;
    }

    private int multiply(int a, int b) {
        return a * b;
    }

    private int divine(int a, int b) {
        return a / b;
    }
}
