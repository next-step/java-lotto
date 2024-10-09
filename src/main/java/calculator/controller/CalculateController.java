package calculator.controller;

import calculator.domain.StringCalculate;
import calculator.view.InputView;
import calculator.view.ResultView;

import java.util.Scanner;

import static calculator.view.InputView.splitFormula;

public class CalculateController {
    private static final ResultView RESULT_VIEW = new ResultView();
    private static final InputView INPUT_VIEW = new InputView();

    public static void main(String[] args) {

        INPUT_VIEW.view();
        Scanner scanner = new Scanner(System.in);
        String[] formulas = splitFormula(scanner.nextLine());

        StringCalculate calculate = new StringCalculate(formulas, formulas);
        RESULT_VIEW.view(calculate.calculates());

    }

}
