package step1.domain;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Equation {

    private final List<String> equation;

    public Equation(List<String> equation) {
        checkValidation(equation);
        this.equation = equation;
    }

    public Number calculate() {
        Number result = new Number(0);
        Operator operator = Operator.PLUS;
        for (String target : equation) {
            if (operator == null) {
                operator = Operator.symbolOf(target);
                continue;
            }
            result = result.operate(operator, Number.of(target));
            operator = null;
        }
        if (operator != null) {
            throw new IllegalArgumentException();
        }
        return result;
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
