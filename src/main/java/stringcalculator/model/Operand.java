package stringcalculator.model;

import java.util.LinkedList;
import java.util.Queue;

public class Operand {
    public static final String OPERAND_REGEX = "\\d+";
    private final Queue<Integer> operand = new LinkedList<>();

    public Operand(String[] textArr) {
        for (String text : textArr) {
            addOperand(text);
        }
    }

    private void addOperand(String text) {
        if (text.matches(OPERAND_REGEX)) {
            this.operand.add(Integer.parseInt(text));
        }
    }

    int pop() {
        return operand.remove();
    }

    boolean hasNext() {
        return operand.iterator().hasNext();
    }

}
