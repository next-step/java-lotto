package Calculator;

import Calculator.Operator.*;

public class Calculator {
    private final String inputString;
    private int result;

    public Calculator(String inputString) {
        if (inputString == null || inputString.trim().isEmpty()) {
            throw new IllegalArgumentException("입력 값이 null이거나 빈 공백 문자입니다.");
        }

        this.inputString = inputString;
    }

    public int getResult() {
        return result;
    }

    public void calculate() {
        String[] splitInputString = this.inputString.split(" ");

        this.result = Integer.parseInt(splitInputString[0]);

        for (int i = 1; i < splitInputString.length; i += 2) {

            int operand1 = this.result;
            int operand2 = Integer.parseInt(splitInputString[i + 1]);
            String curOperator = splitInputString[i];

            OperatorProcess operatorProcess = new OperatorProcess(operand1,operand2,curOperator);
            this.result = operatorProcess.calculateProcess();

        }

    }
}



