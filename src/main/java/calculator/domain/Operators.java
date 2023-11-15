package calculator.domain;

import java.util.ArrayList;
import java.util.List;

public class Operators {

    private final List<String> operators = new ArrayList<>();

    public Operators(String[] inputs) {
        int i = 0;
        for (String o : inputs) {
            addOperator(i, o);
            ++i;
        }
    }

    public List<String> gerOperators() {
        return this.operators;
    }

    public String operator(int position) {
        return this.operators.get(position);
    }

    private void addOperator(int i, String o) {
        if (i % 2 != 0) {
            validateOperator(o);
            this.operators.add(o);
        }
    }

    private void validateOperator(String o) {
        if (!o.equals("+") && !o.equals("-") && !o.equals("*") && !o.equals("/")) {
            throw new IllegalArgumentException();
        }
    }
}
