package calculator;

import calculator.controller.NumberController;
import calculator.view.NumberInputView;
import calculator.view.NumberOutputView;

public class NumberApplication {

    public static void main(String[] args) {
        NumberController numberController = new NumberController(
                new NumberInputView(),
                new NumberOutputView()
        );

        numberController.calculate();
    }
}
