package calculator.domain;

import java.util.ArrayList;
import java.util.List;

public class Operators {

    private final List<String> operators;

    public Operators(String[] inputs) {
        int i = 0;
        List<String> operators = new ArrayList<>();
        for (String o : inputs) {
            addOperator(i, operators, o);
            ++i;
        }
        this.operators = operators;
    }

    public List<String> operators() {
        return this.operators;
    }

    private void addOperator(int i, List<String> operators, String o) {
        if (i % 2 != 0) {
            validateOperator(o);
            operators.add(o);
        }
    }

    private void validateOperator(String o) {
        if (!o.equals("+") && !o.equals("-") && !o.equals("*") && !o.equals("/")) {
            throw new IllegalArgumentException();
        }
    }
}
