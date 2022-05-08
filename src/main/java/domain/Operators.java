package domain;

import java.util.LinkedList;
import java.util.Queue;

public class Operators {

    private static Queue<Operator> operators = new LinkedList<>();

    public Operators(String[] userInputs) {
        for (String input : userInputs){
            if (Operator.isOperator(input)){
                operators.add(new Operator(input));
            }
        }
    }

    public Operand calculate(Operands operands) {
        Operand result = operands.getNextOperand();
        while (!operators.isEmpty()){
            result = calculate(result, operands.getNextOperand());
        }
        return result;
    }

    private Operand calculate(Operand leftValue, Operand rightValue){
        Operator operator = operators.poll();
        return operator.calculate(leftValue, rightValue);
    }
}
