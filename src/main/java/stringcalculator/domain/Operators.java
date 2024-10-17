package stringcalculator.domain;

import stringcalculator.domain.calculation.Addition;
import stringcalculator.domain.calculation.Calculation;
import stringcalculator.domain.calculation.Division;
import stringcalculator.domain.calculation.Multiplication;
import stringcalculator.domain.calculation.Subtraction;

import java.util.Map;

public class Operators {
    private static final Map<String, Calculation> operatorMap = Map.of("+", new Addition(),
                                                                       "-", new Subtraction(),
                                                                       "*", new Multiplication(),
                                                                       "/", new Division());

    public static Calculation find(String operator) {
        return operatorMap.get(operator);
    }
}
