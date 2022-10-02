package calculator;

import calculator.exception.EmptyFormulaException;
import calculator.exception.InvalidFormulaException;
import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;

public class FormulaElements {

    private static final String DELIMITER = " ";
    private static final String INIT_OPERATOR = "+";

    private final Queue<String> formulaElementQueue;

    public FormulaElements(String formula) {
        this.formulaElementQueue = getSplitFormula(formula);
    }

    private Queue<String> getSplitFormula(String formula) {
        if (formula == null || formula.isBlank()) {
            throw new EmptyFormulaException();
        }

        return generatorQueueWithInitOperator(formula);
    }

    private Queue<String> generatorQueueWithInitOperator(String formula) {
        Deque<String> splitFormula = new LinkedList<>(Arrays.asList(formula.split(DELIMITER)));
        splitFormula.addFirst(INIT_OPERATOR);
        return splitFormula;
    }

    public String poll() {
        if (formulaElementQueue.isEmpty()) {
            throw new InvalidFormulaException();
        }
        return formulaElementQueue.poll();
    }

    public boolean isEmpty() {
        return formulaElementQueue.isEmpty();
    }
}
