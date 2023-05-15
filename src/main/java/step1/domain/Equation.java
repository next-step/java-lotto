package step1.domain;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Equation {

    private final List<String> equation;

    public static Equation of(String rawEquation){
        return new Equation(Arrays.stream(rawEquation.split(" "))
            .map(String::trim)
            .collect(Collectors.toList()));
    }

    public Equation(List<String> equation) {
        checkValidation(equation);
        this.equation = equation;
    }

    public Number calculate() {
        Number result = new Number(0);
        Number targetNumber;
        Operator operator = Operator.PLUS;
        for (String target : equation) {
            operator = transferOperator(target);
            targetNumber = transferNumber(target);
            result = result.operate(operator, targetNumber);
            operator = null;
        }
        if (operator != null) {
            throw new IllegalArgumentException();
        }
        return result;
    }

    private Number transferNumber(String target) {
        try {
            return Number.of(target);
        } catch (IllegalArgumentException e) {
            return new Number(0);
        }
    }

    private Operator transferOperator(String target) {
        try {
            return Operator.symbolOf(target);
        } catch (IllegalArgumentException e) {
            return null;
        }

    }


    private static void checkValidation(List<String> equation) {
        for (int i = 0; i < equation.size(); i++) {
            checkNumber(equation, i);
            checkOperator(equation, i);
        }
        Number.checkNumber(equation.get(equation.size()-1));
    }

    private static void checkOperator(List<String> equation, int index) {
        if (index % 2 == 0) {
            Number.checkNumber(equation.get(index));
        }
    }

    private static void checkNumber(List<String> equation, int index) {
        if (index % 2 == 1) {
            Operator.checkOperator(equation.get(index));
        }
    }


}
