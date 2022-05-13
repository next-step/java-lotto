package calculator.domain;

import calculator.domain.operation.Addition;
import calculator.domain.operation.Division;
import calculator.domain.operation.Multiplication;
import calculator.domain.operation.Subtraction;

import java.util.List;

public class Calculator {

    public int calculate(List<Integer> numberList, List<Character> operatorList) {
        int result = numberList.get(0);
        int numberIndex = 0;
        for (char operator : operatorList) {
            numberIndex++;
            result = operate(result, numberList.get(numberIndex), operator);
        }

        return result;
    }

    private int operate(int number1, int number2, char operator) {
        if (operator == '+') {
            return new Addition(number1, number2).getResult();
        }
        if (operator == '-') {
            return new Subtraction(number1, number2).getResult();
        }
        if (operator == '*') {
            return new Multiplication(number1, number2).getResult();
        }
        if (operator == '/') {
            return new Division(number1, number2).getResult();
        }
        throw new IllegalArgumentException("연산자는 사칙연산만 가능합니다.");
    }

}
