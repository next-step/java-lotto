package Step1;


import java.util.*;

public class CalculatorService {

    private final Calculator calculator;
    private final StringConverter stringConverter;

    public CalculatorService() {
        calculator = new Calculator();
        stringConverter = new StringConverter();
    }

    public int calculate(String mathEquation) {
        MathEquationValidator.validate(mathEquation);
        List<String> decomposedMathEquation = stringConverter.convertToList(mathEquation);
        Deque<String> mathEquationDeque = convertListToDeque(decomposedMathEquation);

        while (mathEquationDeque.size() > 1) {
            int calculationResult = calculate(Integer.parseInt(mathEquationDeque.removeFirst()), mathEquationDeque.removeFirst(), Integer.parseInt(mathEquationDeque.removeFirst()));
            mathEquationDeque.addFirst(String.valueOf(calculationResult));
        }

        return Integer.parseInt(mathEquationDeque.pop());
    }

    private Deque<String> convertListToDeque(List<String> decomposedMathEquation) {
        return new ArrayDeque<>(decomposedMathEquation);
    }

    private int calculate(int num1, String operatorSymbol, int num2) {
        if (operatorSymbol.equals("+")) {
            return calculator.addition(num1, num2);
        }

        if (operatorSymbol.equals("-")) {
            return calculator.subtraction(num1, num2);
        }

        if (operatorSymbol.equals("*")) {
            return calculator.multiplication(num1, num2);
        }

        return calculator.division(num1, num2);
    }
}
