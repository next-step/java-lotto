package lotto.ui;

import lotto.domain.LottoResult;
import lotto.domain.Message;

public class OutputView {

    public void printExceptionMessage(Exception e) {
        System.out.println(e.getMessage());
    }

    public void printLottoResult(LottoResult result) {
        System.out.println(Message.INFO_BEFORE_PRINT_LOTTO_RESULT.getText());
        System.out.println(result.toString());
    }

    public void printInfo(String arg1) {
        System.out.println(arg1);
    }

    public void printMessage(Message message) {
        System.out.println(message.getText());
    }

    public void printMessage(Message message, Object arg1) {
        System.out.printf((message.getText()) + "%n", arg1);
    }

    public void printMessage(Message message, Object arg1, Object arg2) {
        System.out.printf((message.getText()) + "%n", arg1, arg2);
    }
}
