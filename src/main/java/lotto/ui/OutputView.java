package lotto.ui;

import lotto.enums.MessageEnum;
import lotto.lotto.Lotto;
import lotto.lotto.LottoTicket;

public class OutputView {
    public static void printInputMoneyMessage() {
        println(MessageEnum.INPUT_MONEY.message());
    }

    public static void inputWinningNumber() {
        println(MessageEnum.INPUT_LOTTO_ANSWER.message());
    }

    public static void printLottoAmount(int amount) {
        println(MessageEnum.LOTTO_PURCHASE.message(), amount);
    }

    public static void printLottoBundle(LottoTicket lottoTicket) {
        for(Lotto lotto : lottoTicket.tickets()) {
            printLotto(lotto);
        }
    }

    public static void resultMessage() {
        println(MessageEnum.RESULT.message());
        println(MessageEnum.LINE.message());
    }

    private static void printLotto(Lotto lotto) {
        String collect = lotto.numbersToString();
        System.out.println("[" + collect + "]");
    }

    private static void println(String message) {
        System.out.println(message);
    }

    private static void println(String message, int amount) {
        System.out.println(amount + message);
    }
}