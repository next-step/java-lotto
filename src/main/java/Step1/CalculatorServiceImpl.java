package Step1;

import Step1.intefaces.Calculator;
import Step1.intefaces.CalculatorService;

import java.util.*;

public class CalculatorServiceImpl implements CalculatorService {

    private Calculator calculator;

    public CalculatorServiceImpl() {
        calculator = new CalculatorImpl();
    }

    @Override
    public int calculate(String mathEquation) {
        MathEquationValidator.validate(mathEquation);
        List<String> decomposedMathEquation = StringConverter.convertToList(mathEquation);
        Stack<String> mathEquationStack = convertListToStack(decomposedMathEquation);

        while (mathEquationStack.size() > 1) {
            int calculationResult = calculate(Integer.parseInt(mathEquationStack.pop()), mathEquationStack.pop(), Integer.parseInt(mathEquationStack.pop()));
            mathEquationStack.push(String.valueOf(calculationResult));
        }

        return Integer.parseInt(mathEquationStack.pop());
    }

    private Stack<String> convertListToStack(List<String> decomposedMathEquation) {
        Stack<String> stack = new Stack<>();
        Collections.reverse(decomposedMathEquation);
        decomposedMathEquation.forEach(stack::push);
        return stack;
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
