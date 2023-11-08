package calculator.controller;

import calculator.domain.OperationManager;
import calculator.view.InputView;
import calculator.view.ResultView;
import java.util.Scanner;

public class CalculatorController {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input = InputView.input(scanner);

        int result = OperationManager.opertaion(input);

        ResultView.report(result);
    }

}
