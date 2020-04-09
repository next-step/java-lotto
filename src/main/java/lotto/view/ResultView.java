package lotto.view;

import lotto.utils.StringUtils;

public class ResultView {

    private static final String CUSTOM_SEPARATOR_PHASE = ".+\n";
    private static final String EMPTY_STRING = "";

    public void printTitle() {
        System.out.println();
        System.out.println("실행 결과");
    }

    public void printResult(final String formula, final int result) {
        final String printFormula = formula.replaceAll(CUSTOM_SEPARATOR_PHASE, EMPTY_STRING);
        final String print = StringUtils.isNullOrEmpty(printFormula) ? "[INPUT NONE]" : printFormula;
        System.out.println( print + " = " + result );
    }
}
