package calculator;

import calculator.exception.EmptyFormulaException;
import calculator.exception.InvalidFormulaException;
import calculator.exception.InvalidOperandException;
import calculator.exception.InvalidOperatorException;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class FormulaCalculator {

    private static final String DELIMITER = " ";

    public static Integer calculate(String formula) {
        Queue<String> splitFormula = getSplitFormula(formula);
        Integer leftOperand = null;

        while (!splitFormula.isEmpty()) {
            leftOperand = calculate(
                    initLeftOperand(leftOperand, splitFormula),
                    poll(splitFormula),
                    parseOperand(poll(splitFormula))
            );
        }

        return leftOperand;
    }

    private static Queue<String> getSplitFormula(String formula) {
        if (formula == null || formula.isBlank()) {
            throw new EmptyFormulaException();
        }
        return new LinkedList<>(Arrays.asList(formula.split(DELIMITER)));
    }

    private static String poll(Queue<String> splitFormula) {
        if (splitFormula.isEmpty()) {
            throw new InvalidFormulaException();
        }
        return splitFormula.poll();
    }

    private static Integer initLeftOperand(Integer leftOperand, Queue<String> splitFormula) {
        if (leftOperand == null) {
            leftOperand = parseOperand(poll(splitFormula));
        }
        return leftOperand;
    }

    private static int parseOperand(String operandStr) {
        try {
            return Integer.parseInt(operandStr);
        } catch (Exception e) {
            throw new InvalidOperandException();
        }

    }

    private static Integer calculate(Integer leftOperand, String operator, Integer rightOperand) {
        if (Calculator.ADD_OPERATOR.equals(operator)) {
            return Calculator.add(leftOperand, rightOperand);
        }

        if (Calculator.SUB_OPERATOR.equals(operator)) {
            return Calculator.sub(leftOperand, rightOperand);
        }

        if (Calculator.MULTIPLY_OPERATOR.equals(operator)) {
            return Calculator.multiply(leftOperand, rightOperand);
        }

        if (Calculator.DIV_OPERATOR.equals(operator)) {
            return Calculator.div(leftOperand, rightOperand);
        }

        throw new InvalidOperatorException();
    }
}
