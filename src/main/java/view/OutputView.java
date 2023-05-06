package view;

import domain.CalculationResult;

public class OutputView {

    private static String END_MESSAGE = "결과가 나왔습니다.";


    public static void printResult(CalculationResult result) {
        System.out.println(END_MESSAGE);
        System.out.println(result);
    }
}
