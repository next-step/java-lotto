package calculator.controller;

import calculator.domain.Number;
import calculator.domain.Operator;
import calculator.view.NumberInputView;

import java.util.Deque;
import java.util.LinkedList;

public class NumberController {

    private final NumberInputView inputView;

    public NumberController(NumberInputView inputView) {
        this.inputView = inputView;
    }

    public void calculate() {
        String input = inputView.inputNumbers();

        String[] split = input.split(" ");

        Deque<Number> numbers = new LinkedList<>();
        Deque<Operator> operators = new LinkedList<>();

        for (int i = 0; i < split.length; i++) {
            addNumbers(i, numbers, split);
            addOperators(i, operators, split);
        }

        Number result = numbers.pollFirst();
        while (!operators.isEmpty()) {
            Operator operator = operators.pollFirst();
            Number operationNumber = numbers.pollFirst();

            result = operator.apply(result, operationNumber);
        }

        System.out.println(result.value());
    }

    private static void addNumbers(int i, Deque<Number> numbers, String[] split) {

        if (isNumber(i)) {
            numbers.add(new Number(split[i]));
        }
    }

    private static boolean isNumber(int i) {
        return i % 2 == 0;
    }

    private static void addOperators(int i, Deque<Operator> operators, String[] split) {


        if (isOperator(i)) {
            operators.add(Operator.fromSymbol(split[i]));
        }
    }

    private static boolean isOperator(int i) {
        return i % 2 == 1;
    }
}
