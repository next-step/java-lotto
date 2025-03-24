class Operand {
    private final String VALUE;

    Operand(String value) {
        this.VALUE = value;
    }

    private int sum(int num1, int num2) {
        return num1 + num2;
    }

    private int subtract(int num1, int num2) {
        return num1 - num2;
    }

    private int multiply(int num1, int num2) {
        return num1 * num2;
    }

    private int divide(int num1, int num2) {
        return num1 / num2;
    }

    int operate(int num1, int num2) {
        if (VALUE.equals("+")) {
            return sum(num1, num2);
        } 
        else if (VALUE.equals("-")) {
            return subtract(num1, num2);
        } 
        else if (VALUE.equals("*")) {
            return multiply(num1, num2);
        } 
        else if (VALUE.equals("/")) {
            return divide(num1, num2);
        } 
        else {
            throw new IllegalArgumentException("지원하지 않는 연산자입니다.");
        }
    }

}
