package domain;

import java.util.LinkedList;
import java.util.Queue;

public class Operands {

    private static Queue<Operand> operands = new LinkedList<>();

    public Operands(String [] userInputs) {
        for (String input : userInputs) {
            if(Operand.isOperand(input)){
                operands.add(new Operand(input));
            }
        }
    }

    public Operand getNextOperand() {
        return operands.poll();
    }
}
