package calculator;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Stack;

public class StringCalculator {

    private static final String PLUS_OPERATOR = "+";
    private static final String MINUS_OPERATOR = "-";
    private static final String MULTIPLY_OPERATOR = "*";
    private static final String DIVIDE_OPERATOR = "/";

    public static int calculate(String input){
        String[] splitedInput = input.split(" ");
        Deque<Integer> operandStack = new ArrayDeque<>();
        Stack<String> operatorStack = new Stack<>();
        for (String param : splitedInput) {
            if (param.equals(PLUS_OPERATOR) || param.equals(MINUS_OPERATOR) || param.equals(MULTIPLY_OPERATOR) || param.equals(DIVIDE_OPERATOR)){
                operatorStack.add(param);
            }else{
                operandStack.add(Integer.valueOf(param));
            }
            if (operandStack.size() == 2){
                String operator = operatorStack.pop();
                if (operator.equals(PLUS_OPERATOR)){
                    operandStack.push(plus(operandStack.pollFirst() , operandStack.pollFirst()));
                }else if (operator.equals(MINUS_OPERATOR)){
                    operandStack.push(minus(operandStack.pollFirst() , operandStack.pollFirst()));
                }else if (operator.equals(MULTIPLY_OPERATOR)){
                    operandStack.push(operandStack.pollFirst() * operandStack.pollFirst());
                }else if (operator.equals(DIVIDE_OPERATOR)){
                    operandStack.push(operandStack.pollFirst() / operandStack.pollFirst());
                }
            }
        }
        return operandStack.pop();
    }

    private static int plus(int x , int y){
        return x+y;
    }

    private static int minus(int x , int y ){
        return x-y;
    }


}
