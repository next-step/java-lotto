package step1.view;

import step1.domain.Operand;

public class ResultView {

    private static final String RESULT_MESSAGE = "실행 결과 : ";

    public void printResultMessage(final Operand operand) {
        System.out.println(RESULT_MESSAGE + operand.getOperandValue());
    }

}
