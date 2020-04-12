package practice.view;

import aterilio.common.utils.StringUtils;

public class ResultView {

    private static final String CUSTOM_SEPARATOR_PHASE = ".+\n";
    private static final String EMPTY_STRING = "";

    private void printTitle() {
        System.out.println();
        System.out.println("실행 결과");
    }

    public void printResult(final String formula, final int result) {
        printTitle();
        final String printFormula = formula.replaceAll(CUSTOM_SEPARATOR_PHASE, EMPTY_STRING);
        final String print = StringUtils.isNullOrEmpty(printFormula) ? "[INPUT NONE]" : printFormula;
        System.out.println( print + " = " + result );
    }
}
