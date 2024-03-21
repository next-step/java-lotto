package calculator.controller;

import calculator.model.Calculation;
import calculator.model.NumberSentence;
import calculator.model.Validator;
import calculator.view.CalculatorInputView;
import calculator.view.CalculatorResultView;

public class Calculator {
    private static final String SEPARATOR = " ";

    private final CalculatorInputView calculatorInputView;
    private final CalculatorResultView calculatorResultView;
    private final Validator validator;

    public Calculator(CalculatorInputView calculatorInputView, CalculatorResultView calculatorResultView, Validator validator) {
        this.calculatorInputView = calculatorInputView;
        this.calculatorResultView = calculatorResultView;
        this.validator = validator;
    }

    public void start() {
        calculatorResultView.printInputNumberSentence();

        String inputNumberSentence = calculatorInputView.inputNumberSentence();
        validator.nullCheck(inputNumberSentence);

        String[] numberSentences = inputNumberSentence.split(SEPARATOR);

        validator.validate(numberSentences);

        NumberSentence numberSentence = new NumberSentence(numberSentences);

        int resultNumber = Calculation.calculate(numberSentence);

        calculatorResultView.printResultNumber(resultNumber);
    }
}
