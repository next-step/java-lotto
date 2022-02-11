package calculator;

import calculator.controller.Calculator;

public class Application {

    public static void main(String[] args) {
        Calculator calculator = Calculator.getInstance();
        calculator.play();
    }
}
