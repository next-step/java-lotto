package calculator;

import calculator.operator.*;

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

        this.inputNumbers = Parser.numberReverseParsing(splitText);
        this.inputOperators = Parser.operatorParsing(splitText);

    }
    public int calculate() {
        int totalOperatorsSize = inputOperators.size();
        for (int i = 0; i < totalOperatorsSize; i++) {
            System.out.println("몇번째?"+i);
            //"4 + 3 - 1 * 2 / 4"
            String operator = inputOperators.pop();
            Integer firstNumber = inputNumbers.pop();
            Integer secondNumber = inputNumbers.pop();
            System.out.println("firstNumber : " + firstNumber);
            System.out.println("operator : " + operator);
            System.out.println("secondNumber : " + secondNumber);
            if(operator.equals("+")) {
                Operator add = new AddOperator();
                System.out.println("계산결과 : " + add.calculate(firstNumber, secondNumber));
                inputNumbers.push(add.calculate(firstNumber, secondNumber));
                continue;
            }

            if(operator.equals("-")) {
                Operator minus = new MinusOperator();
                System.out.println("계산결과 : " + minus.calculate(firstNumber, secondNumber));
                inputNumbers.push(minus.calculate(firstNumber, secondNumber));
                continue;
            }

            if(operator.equals("*")) {
                Operator multiply = new MultiplyOperator();
                System.out.println("계산결과 : " + multiply.calculate(firstNumber, secondNumber));
                inputNumbers.push(multiply.calculate(firstNumber, secondNumber));
                continue;
            }

            if(operator.equals("/")) {
                Operator divide = new DivideOperator();
                System.out.println("계산결과 : " + divide.calculate(firstNumber, secondNumber));
                inputNumbers.push(divide.calculate(firstNumber, secondNumber));
                continue;
            }
        }
        int result = inputNumbers.pop();
        System.out.println(result);
        return result;
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
