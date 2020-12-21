package com.ssabae.nextstep.stringcalculator;

import com.ssabae.nextstep.stringcalculator.calculator.StringAddCalculator;
import com.ssabae.nextstep.stringcalculator.view.Printer;
import com.ssabae.nextstep.stringcalculator.view.UserInputHelper;

/**
 * @author : leesangbae
 * @project : java-lotto
 * @since : 2020-12-14
 */
public class StringAddCalculatorApplication {

    private final StringAddCalculator calculator;

    public StringAddCalculatorApplication() {
        calculator = new StringAddCalculator();
    }

    public static void main(String[] args) {
        new StringAddCalculatorApplication().launch();
    }

    public void launch() {

        String userInputValue = UserInputHelper.inputString();
        int result = calculator.calculate(userInputValue);
        Printer.printCalculatedResult(result);
    }
}
