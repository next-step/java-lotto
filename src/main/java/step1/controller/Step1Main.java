package step1.controller;

import step1.domain.StringAddCalculator;
import step1.util.InputUtil;
import step1.util.StringUtil;
import step1.view.PrintResult;

import java.util.Scanner;

public class Step1Main {
    public static void main(String[] args) {
        String problem = InputUtil.returnString("쉼표(,) 또는 콜론(:)을 구분자로 가지는 문자열");
        StringAddCalculator stringAddCalculator = new StringAddCalculator(problem);
        PrintResult.printResult(stringAddCalculator.splitAndSum());
    }
}
