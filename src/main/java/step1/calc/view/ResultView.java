package step1.calc.view;

import step1.calc.operand.Operand;

public class ResultView {


    public static void printResult(Operand result) {
        System.out.println(result.operand());
    }
}
