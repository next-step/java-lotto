package stringCalculator;

import jdk.jshell.execution.Util;

public class Calculator {
    private static final String ADDITION = "+";
    private static final String SUBSTRACTION = "-";
    private static final String MULTIPLICATION = "*";

    private int result;

    public int calculator(String input){
        Utils.checkBlank(input);
        String[] separateString = Utils.splitString(input);
        Utils.checkNumOrOperators(separateString);
        Utils.checkNumAndOperatorAlternately(separateString);
        Utils.checkLastElement(separateString);

        this.result = Integer.parseInt(separateString[0]);

        for (int i = 1; i < separateString.length; i = i + 2) {
            this.result = calStepByStep(separateString[i], separateString[i + 1]);
        }
        return this.result;
    }

    private int calStepByStep(String operator, String num){
        int operand = Integer.parseInt(num);

        if(operator.equals(ADDITION)){
            return this.result + operand;
        }
        if(operator.equals(SUBSTRACTION)){
            return this.result - operand;
        }
        if(operator.equals(MULTIPLICATION)){
            return this.result * operand;
        }
        return division(operand);
    }

    private int division(int input){
        if(input == 0){
            throw new IllegalArgumentException("0으로 나눌 수 없습니다.");
        }

        if(result % input != 0){
            throw new IllegalArgumentException("정수로 나누어 지지 않습니다.");
        }
        return this.result / input;
    }

}
