package calculator.controller;

import calculator.domain.StringCalculate;
import calculator.util.InputViewUtil;
import calculator.util.ResultViewUtil;

import java.util.Scanner;

import static calculator.util.InputViewUtil.splitFormula;

public class CalculateController {


    public static void main(String[] args) {

        InputViewUtil.view();
        Scanner scanner = new Scanner(System.in);
        String[] formulas = splitFormula(scanner.nextLine());

        StringCalculate calculate = new StringCalculate(formulas, formulas);
        ResultViewUtil.view(calculate.calculates());

    }

}
