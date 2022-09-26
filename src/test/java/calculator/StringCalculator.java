package calculator;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Stack;

public class StringCalculator {

    private static final String DEFAULT_DELIMITER = " ";

    public static int calculate(String input){
        String[] splitedInput = input.split(DEFAULT_DELIMITER);
        Deque<Integer> operandStack = new ArrayDeque<>();
        Stack<Operator> operatorStack = new Stack<>();
        for (String param : splitedInput) {
            if (Operator.isOperator(param)){
                operatorStack.add(Operator.getOperator(param));
            }else{
                operandStack.add(Integer.valueOf(param));
            }
            if (operandStack.size() == 2){
                Operator operator = operatorStack.pop();
                operandStack.add(operator.operation.apply(operandStack.pollFirst(), operandStack.pollFirst()));
            }
        }
        return operandStack.pop();
    }

}
