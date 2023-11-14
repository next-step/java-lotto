package calculator;

import calculator.controller.NumberController;
import calculator.view.NumberInputView;

public class NumberApplication {

    public static void main(String[] args) {
        NumberController numberController = new NumberController(new NumberInputView());

        numberController.calculate();
    }
}
