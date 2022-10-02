package step01.domain;

import java.util.List;

public class Calculator {

    public static Integer calc(Expression expression) {
        CalculationPreset calculationPreset = expression.createCalculationPreset();

        List<Integer> numbers = calculationPreset.getIntegers();
        List<Operator> operators = calculationPreset.getOperations();

        Integer result = numbers.get(0);
        int size = operators.size();
        for (int i = 0; i < size; i++) {
            Operator operator = operators.get(i);
            int nextNum = numbers.get(i + 1);
            result = operator.operate(result, nextNum);
        }

        return result;
    }
}

