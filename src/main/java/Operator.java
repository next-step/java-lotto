public class Operator {
    private static final String PLUS_STRING = "+";
    private static final String MINUS_STRING = "-";
    private static final String MULTIPLY_STRING = "*";
    private static final String DIVIDE_STRING = "/";

    public static void main(String[] args) {
        Output.print("계산을 원하는 연산을 입력하세요.");
        String inputString = Input.inputString();
        checkInputString(inputString);

        String[] inputArr = inputString.split(" ");
        Calculator calculator = new Calculator(stringToInteger(inputArr[0]));
        for (int i=1; i<inputArr.length; i+=2) {
            findOperator(calculator, inputArr[i], inputArr[i+1]);
        }
        Output.print(calculator.getResult());
    }

    private static void findOperator(Calculator calculator, String operator, String stringNumber) {
        if (operator.equals(PLUS_STRING)) {
            calculator.plus(stringToInteger(stringNumber));
            return;
        }
        if (operator.equals(MINUS_STRING)) {
            calculator.minus(stringToInteger(stringNumber));
            return;
        }
        if (operator.equals(MULTIPLY_STRING)) {
            calculator.multiply(stringToInteger(stringNumber));
            return;
        }
        if (operator.equals(DIVIDE_STRING)) {
            calculator.divide(stringToInteger(stringNumber));
            return;
        }

        throw new IllegalArgumentException();
    }

    private static int stringToInteger(String stringNumber) {
        return Integer.parseInt(stringNumber);
    }

    private static void checkInputString(String str) {
        if (str.isEmpty() || str == null) {
            throw new IllegalArgumentException();
        }
    }
}
