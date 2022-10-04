package stringCalculator.service;


import stringCalculator.validator.MathEquationValidator;
import stringCalculator.utils.StringConverter;

import java.util.*;

public class CalculateService {

    private final StringConverter stringConverter;

    public CalculateService() {
        stringConverter = new StringConverter();
    }

    public int calculate(String mathEquation) {
        MathEquationValidator.validate(mathEquation);

        List<String> decomposedMathEquation = stringConverter.convertToList(mathEquation);
        Deque<String> mathEquationDeque = convertListToDeque(decomposedMathEquation);

        while (mathEquationDeque.size() > 1) {
            int calculateResult = calculate(
                    Integer.parseInt(mathEquationDeque.removeFirst()),
                    mathEquationDeque.removeFirst(),
                    Integer.parseInt(mathEquationDeque.removeFirst())
            );
            mathEquationDeque.addFirst(String.valueOf(calculateResult));
        }

        return Integer.parseInt(mathEquationDeque.pop());
    }

    private Deque<String> convertListToDeque(List<String> decomposedMathEquation) {
        return new ArrayDeque<>(decomposedMathEquation);
    }

    private int calculate(int num1, String operatorSymbol, int num2) {
        if (operatorSymbol.equals("+")) {
            return num1 + num2;
        }

        if (operatorSymbol.equals("-")) {
            return num1 - num2;
        }

        if (operatorSymbol.equals("*")) {
            return num1 * num2;
        }

        return num1 / num2;
    }
}
