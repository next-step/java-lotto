package stringCalculator.controller;

import stringCalculator.domain.StringCalculation;
import stringCalculator.view.InputView;

public class StringCalculatorController {
    public static void main(String[] args) {

        // 입력 및 계산
        String[] stringArray = InputView.inputOperationsAndNumber();
        for (int i = 0; i < stringArray.length; i++) {
            new StringCalculation(stringArray[i], i+1);
        }

        StringCalculation calculation = new StringCalculation();
        calculation.calculate();

        System.out.println(calculation.toString());

    }

}
