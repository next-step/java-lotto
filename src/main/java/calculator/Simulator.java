package calculator;

import calculator.controller.InputController;
import calculator.model.Calculator;
import calculator.model.Classifier;
import calculator.model.InputNumber;
import calculator.model.Operator;

public class Simulator {
    public static void main(String[] args) {
        String[] input = InputController.getInput();
        Operator operator = new Operator(Classifier.classifyOperator(input));
        InputNumber inputNumber = new InputNumber(Classifier.classifyInteger(input));
        Calculator calculator = new Calculator(inputNumber, operator);
        System.out.println(calculator.calculate());
    }
}
