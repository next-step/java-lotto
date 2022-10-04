package calculator;

import calculator.exception.EmptyFormulaException;
import calculator.exception.InvalidFormulaException;
import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;

public class FormulaElements {

    private static final String DELIMITER = " ";
    private static final String INIT_OPERATOR = "+";

    private final Deque<String> elements;

    public FormulaElements(String formula) {
        this.elements = getSplitFormula(formula);
    }

    private Deque<String> getSplitFormula(String formula) {
        if (formula == null || formula.isBlank()) {
            throw new EmptyFormulaException();
        }

        return generatorDequeWithInitOperator(formula);
    }

    private Deque<String> generatorDequeWithInitOperator(String formula) {
        Deque<String> splitFormula = new LinkedList<>(Arrays.asList(formula.split(DELIMITER)));
        splitFormula.addFirst(INIT_OPERATOR);
        return splitFormula;
    }

    public String poll() {
        if (elements.isEmpty()) {
            throw new InvalidFormulaException();
        }
        return elements.poll();
    }

    public boolean isEmpty() {
        return elements.isEmpty();
    }
}
