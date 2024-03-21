package calculator.domain;

import java.util.Arrays;
import java.util.List;

public class ParsedFormula {
    private final int INITIAL_VALUE_INDEX = 0;
    private List<String> parsedFormula;

    ParsedFormula(List<String> parsedFormula) {
        this.parsedFormula = parsedFormula;
    }

    ParsedFormula(String formula) {
        this(Arrays.asList(formula.split(" ")));
    }

    public int getInitialValue() {
        return Integer.parseInt(
                this.parsedFormula.get(INITIAL_VALUE_INDEX)
        );
    }

    public String getNextOperator(int currentPosition) {
        return this.parsedFormula.get(currentPosition);
    }

    public int getNextOperand(int currentPosition) {
        return Integer.parseInt(this.parsedFormula.get(currentPosition + 1));
    }

    public int getLength() {
        return this.parsedFormula.size();
    }
}
