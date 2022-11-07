package domain;

import view.InputView;


public class Main {
    public static void main(String[] args) {

        String[] splitArr = InputView.inputValues();

        Calculator calculator = new Calculator(splitArr);
        calculator.calculateAll();
        System.out.println(calculator.getResult());
    }

}
