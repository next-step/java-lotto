package calculator;

import java.util.LinkedList;
import java.util.Queue;

public class Formular {
    private Queue<Operand> operands;
    private Queue<Operator> operators;

    public Formular(String rawFormular) {
        initialize(rawFormular);
    }

    private void initialize(String rawFormular) {
        String[] formularTokens = rawFormular.split(" ");

        FormularValidator.validate(formularTokens);

        this.operands = new LinkedList<>();
        this.operators = new LinkedList<>();

        for (int i = 0; i < formularTokens.length; i++) {
            makeOperatorAndOperand(i % 2 == 0, formularTokens[i]);
        }
    }

    private void makeOperatorAndOperand(boolean isEven, String formularToken) {
        if (isEven) {
            operands.add(new Operand(formularToken));
            return;
        }
        operators.add(new Operator(formularToken));
    }

    public Operand getNextOperand() {
        return operands.remove();
    }

    public Operator getNextOperator() {
        return operators.remove();
    }

    public boolean hasOperand() {
        return !operands.isEmpty();
    }
}