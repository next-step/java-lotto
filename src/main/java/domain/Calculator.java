package domain;

import domain.formula.Formula;
import java.util.Queue;

public class Calculator {

    private static final CalculationFactory CALCULATION_FACTORY = new CalculationFactory();

    private CalculationResult calculationResult;

    public Calculator(CalculationResult calculationResult) {
        this.calculationResult = calculationResult;
    }

    public static Calculator calculate(Formula formula) {
        Queue<Integer> numbers = formula.numbers();
        Queue<String> operators = formula.operators();

        int result = firstCalculate(numbers, operators);

        while (numbers.iterator().hasNext()) {
            result = getCalculatorByOperator(operators)
                    .calculate(result, numbers.poll());
        }

        CalculationResult calculationResult = new CalculationResult(result);
        return new Calculator(calculationResult);
    }

    private static int firstCalculate(Queue<Integer> numbers, Queue<String> oerpators) {
        return getCalculatorByOperator(oerpators)
                .calculate(numbers.poll(), numbers.poll());
    }

    private static Calculation getCalculatorByOperator(Queue<String> operators) {
        return CALCULATION_FACTORY.getCalculatorByOperator(operators.poll());
    }

    public CalculationResult getResult() {
        return calculationResult;
    }
}
