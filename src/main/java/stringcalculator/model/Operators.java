package stringcalculator.model;

import java.util.LinkedList;
import java.util.Queue;
import java.util.regex.Pattern;

import static stringcalculator.model.Operands.OPERAND_PATTERN;

public class Operators {
    public static final String OPERATOR_REGEX = "[+\\-*/]";
    public static final Pattern OPERATOR_PATTERN = Pattern.compile(OPERATOR_REGEX);
    private Queue<Operator> operator = new LinkedList<>();

    public Operators() {
    }

    public Operators(String text) {
        this.checkOtherOperator(text);
    }

    public Operators(String[] textArr) {
        for (String text : textArr) {
            addOperator(text);
        }
    }

    private void addOperator(String text) {
        this.checkOtherOperator(text);
        if (OPERATOR_PATTERN.matcher(text).matches()) {
            operator.add(Operator.from(text));
        }
    }

    private void checkOtherOperator(String text) {
        if (!OPERATOR_PATTERN.matcher(text).matches() && !OPERAND_PATTERN.matcher(text).matches()) {
            throw new IllegalArgumentException();
        }
    }

    int operate(int i, int j) {
        Operator operator = this.pop();
        return operator.apply(i, j);
    }

    Operator pop() {
        return operator.remove();
    }
}
