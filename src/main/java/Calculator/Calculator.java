package Calculator;

public class Calculator {
    private String inputString;

    public Calculator(String inputString) {
        if (inputString == null || inputString.trim().isEmpty()) {
            throw new IllegalArgumentException("입력 값이 null이거나 빈 공백 문자입니다.");
        }

        this.inputString = inputString;
    }

    public int calculate() {
        String[] splitInputString = this.inputString.split(" ");

        int result = Integer.parseInt(splitInputString[0]);

        for (int i = 1; i < splitInputString.length; i += 2) {

            int operand1 = result;
            int operand2 = Integer.parseInt(splitInputString[i + 1]);
            String curOperator = splitInputString[i];

            Operator operator = new Operator(curOperator);
            result += operator.calculateProcess(operand1, operand2);
        }

        return result;
    }

}

