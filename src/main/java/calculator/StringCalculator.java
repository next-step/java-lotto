package calculator;

import calculator.model.Formula;
import calculator.model.Number;
import calculator.model.Operator;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class StringCalculator {
    private static final String CALCULATION_DELIMITER = " ";

    private final Queue<String> numberOperators = new LinkedList<>();

    public StringCalculator(Formula formula) {
        this(Arrays.asList(formula.split(CALCULATION_DELIMITER)));
    }

    public StringCalculator(List<String> formulas) {
        numberOperators.addAll(formulas);
    }

    public Number calculate() {
        Number resultNumber = new Number(numberOperators.poll());

        while (!numberOperators.isEmpty()) {
            Operator operator = Operator.create(this.numberOperators.poll());
            Number operand = new Number(this.numberOperators.poll());
            resultNumber = operator.calculate(resultNumber, operand);
        }

        return resultNumber;
    }
}
