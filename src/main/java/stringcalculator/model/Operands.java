package stringcalculator.model;

import java.util.LinkedList;
import java.util.Queue;
import java.util.regex.Pattern;

public class Operands {
    public static final String OPERAND_REGEX = "\\d+";
    public static final Pattern OPERAND_PATTERN = Pattern.compile(OPERAND_REGEX);
    private final Queue<Integer> operand = new LinkedList<>();

    public Operands(String[] textArr) {
        for (String text : textArr) {
            addOperand(text);
        }
    }

    private void addOperand(String text) {
        if (OPERAND_PATTERN.matcher(text).matches()) {
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
