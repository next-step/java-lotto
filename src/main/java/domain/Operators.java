package domain;

import domain.calculation.Addition;
import domain.calculation.Calculation;
import domain.calculation.Division;
import domain.calculation.Multiplication;
import domain.calculation.Subtraction;

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
