package calculator;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Stack;

public class StringCalculator {

    private static final String DEFAULT_DELIMITER = " ";

    public static Operand calculate(String input){
        Deque<Operand> operandStack = new ArrayDeque<>();
        Stack<Operator> operatorStack = new Stack<>();
        for (String param :  input.split(DEFAULT_DELIMITER)) {
            if (Operator.isOperator(param)){
                operatorStack.add(Operator.getOperator(param));
            }else{
                operandStack.add(new Operand(param));
            }
            if (operandStack.size() == 2){
                Operator operator = operatorStack.pop();
                operandStack.add(operator.operation.apply(operandStack.pollFirst(), operandStack.pollFirst()));
            }
        }
        return operandStack.pop();
    }

}
