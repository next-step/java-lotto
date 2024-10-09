package step1;

import java.util.function.IntBinaryOperator;

public class StringCalculator {

    public StringCalculator() {
    }

    public int calculate(String input){
        validInput(input);
        return calculateExpression(splitString(input));
    }

    public String[] splitString(String input) {
        return  input.split(" ");
    }

    private static void validInput(String input) {
        if(input == null || input.isEmpty()){
            throw new IllegalArgumentException("올바르지 않은 계산 식 (null 혹은 빈문자열)");
        }
    }

    public int calculateExpression(String[] expression) {
        int result = Integer.parseInt(expression[0]);
        
        for (int i = 1; i < expression.length - 1; i += 2) {
            int operand = Integer.parseInt(expression[i+1]);
            IntBinaryOperator operator = OperaterSelection.selection(expression[i]);
            result = operator.applyAsInt(result,operand);
        }
        return result;
    }

}
