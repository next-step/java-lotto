package Calculator;

public class Calculator {
    String inputString;
    int result;

    public Calculator(String inputString) {
        if (inputString.isEmpty())
            throw new IllegalArgumentException("입력 값이 null이거나 빈 공백 문자입니다.");

        this.inputString = inputString;
    }

    public Calculator() {

    }

    public int calculate() {
        String[] splitInputString = this.inputString.split(" ");

        this.result = Integer.parseInt(splitInputString[0]);

        for (int i = 1; i < splitInputString.length; i += 2) {
            calculateProcess(this.result, Integer.parseInt(splitInputString[i + 1]), splitInputString[i]);
        }

        return result;
    }

    public void calculateProcess(int operand1, int operand2, String operator) {
        switch (operator) {
            case "+":
                this.result = add(operand1, operand2);
                break;
            case "-":
                this.result = minus(operand1, operand2);
                break;
            case "*":
                this.result = multiply(operand1, operand2);
                break;
            case "/":
                this.result = divide(operand1, operand2);
                break;
            default:
                throw new IllegalArgumentException(operator + "는 사칙연산 기호가 아닙니다: ");
        }
    }

    public int add(int operand1, int operand2) {
        return operand1 + operand2;
    }

    public int minus(int operand1, int operand2) {
        return operand1 - operand2;
    }

    public int multiply(int operand1, int operand2) {
        return operand1 * operand2;
    }

    public int divide(int operand1, int operand2) {
        return operand1 / operand2;
    }
}
