package step1.controller;

import step1.model.FourBasicOperation;
import step1.view.OperatorInputView;
import step1.view.OperatorOutputView;

public class CalculateController {

    public static void main(String[] args) {
        String formula = new OperatorInputView().inputString();
        int result = new FourBasicOperation(formula).run();

        new OperatorOutputView(result).result();
    }
}
