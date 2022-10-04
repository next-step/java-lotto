package calculator.view;

import calculator.domain.CalculationResult;

public class ResultView {

    private ResultView() {}

    public static void resultTitlePrint() {

        System.out.println("실행 결과");
    }

    public static void resultPrint(final CalculationResult calculationResult) {

        System.out.printf("최종 계산값은 %s 입니다.", calculationResult.findLast());
    }
}
