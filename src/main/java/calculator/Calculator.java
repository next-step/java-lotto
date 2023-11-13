package calculator;

import java.util.List;
import java.util.Objects;
import java.util.Stack;

public class Calculator {

    private String text;

    private final Stack<Integer> inputNumbers;
    private final Stack<String> inputOperators;

    public Calculator(String text) {
        Parser.emptyValidate(text);

        List<String> splitText = Parser.split(text);

        this.inputNumbers = Parser.numberParsing(splitText);
        this.inputOperators = Parser.operatorParsing(splitText);

    }
    public int calculate() {
        for (int i = 0; i < inputOperators.size(); i++) {

            String operator = inputOperators.pop();
            Integer firstNumber = inputNumbers.pop();
            Integer secondNumber = inputNumbers.pop();

        }



        return 0;
    }

    public int add(int first, int second) {
        return first + second;
    }

    public int minus(int firstInput, int secondInput) {
        return firstInput - secondInput;
    }

    public int multiply(int firstInput, int secondInput) {
        return firstInput * secondInput;
    }

    public int divide(int firstInput, int secondInput) {
        return firstInput / secondInput;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Calculator that = (Calculator) o;
        return Objects.equals(text, that.text);
    }

    @Override
    public int hashCode() {
        return Objects.hash(text);
    }
}
