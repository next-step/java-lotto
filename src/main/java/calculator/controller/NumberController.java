package calculator.controller;

import calculator.domain.Number;
import calculator.domain.Operator;
import calculator.view.NumberInputView;
import calculator.view.NumberOutputView;

import java.util.Deque;
import java.util.LinkedList;

public class NumberController {

    private static final int EVEN_MEASURE = 2;
    private static final int EVEN = 0;
    private static final int ODD = 1;
    private final NumberInputView inputView;
    private final NumberOutputView outputView;

    public NumberController(NumberInputView inputView, NumberOutputView outputView) {
        this.inputView = inputView;
        this.outputView = outputView;
    }

    public void calculate() {
        String[] input = inputView.inputNumbers();

        Deque<Number> numbers = new LinkedList<>();
        Deque<Operator> operators = new LinkedList<>();

        for (int i = 0; i < input.length; i++) {
            addNumbers(i, numbers, input);
            addOperators(i, operators, input);
        }

        Number result = numbers.pollFirst();
        result = calculate(operators, numbers, result);

        outputView.printResult(result.value());
    }

    private static Number calculate(Deque<Operator> operators, Deque<Number> numbers, Number result) {
        while (!operators.isEmpty()) {
            Operator operator = operators.pollFirst();
            Number operationNumber = numbers.pollFirst();

            result = operator.apply(result, operationNumber);
        }
        return result;
    }


    private void addNumbers(int i, Deque<Number> numbers, String[] split) {
        if (isNumber(i)) {
            numbers.add(new Number(split[i]));
        }
    }

    private boolean isNumber(int i) {
        return i % EVEN_MEASURE == EVEN;
    }

    private void addOperators(int i, Deque<Operator> operators, String[] split) {
        if (isOperator(i)) {
            operators.add(Operator.fromSymbol(split[i]));
        }
    }

    private boolean isOperator(int i) {
        return i % EVEN_MEASURE == ODD;
    }
}
