package stringcalculator;


public class StringCalculator {

    public int calculateString(String input) {
        validateInput(input);
        String[] separatedString = StringUtil.splitString(input);
        int result = toInt(separatedString[0]);

        for (int i = 0; i < separatedString.length - 2; i += 2) {
            result = calculate(result, separatedString[i + 1].charAt(0), toInt(separatedString[i + 2]));
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
            validateDivine(secondOperand);
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

    private void validateDivine(int divineNumber) {
        if (divineNumber == 0) {
            throw new IllegalArgumentException("0으로 나눌 수는 없습니다.");
        }
    }

    private int toInt(String stringTobeInt) {
        return Integer.parseInt(stringTobeInt);
    }

    private void validateInput(String input) {
        if (input == null || input.isEmpty()) {
            throw new IllegalArgumentException("입력값은 null이 될 수 없습니다.");
        }
    }
}
