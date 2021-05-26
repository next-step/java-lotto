package lotto.ui;

import lotto.enums.Message;
import lotto.enums.Prize;
import lotto.lotto.Lotto;
import lotto.lotto.LottoTicket;
import lotto.lotto.LottoResult;
import lotto.shop.Money;

public class OutputView {
    public static void printInputMoneyMessage() {
        println(Message.INPUT_MONEY.message());
    }

    public static void printWinningNumber() {
        println(Message.INPUT_LOTTO_ANSWER.message());
    }

    public static void printLottoAmount(int amount) {
        println(Message.LOTTO_PURCHASE.message(), amount);
    }

    public static void printLottoTicket(LottoTicket lottoTicket) {
        for(Lotto lotto : lottoTicket.tickets()) {
            printLotto(lotto);
        }
    }

    public static void resultMessage() {
        println(Message.RESULT.message());
        println(Message.LINE.message());
    }

    public static void resultIncome(LottoResult lottoResult, Money money) {
        for (Prize prizeValue : Prize.values()) {
            printLottoResult(prizeValue, prizeValue.money(), lottoResult);
        }
        printIncome(lottoResult, money);
    }

    public static void printBonusNumber() {
        println(Message.INPUT_BONUS_NUMBER.message());
    }

    private static void printLotto(Lotto lotto) {
        String collect = lotto.numbersToString();
        println("[" + collect + "]");
    }

    private static void println(String message) {
        System.out.println(message);
    }

    private static void println(String message, int amount) {
        System.out.println(amount + message);
    }

    private static void printLottoResult(Prize prize, int money, LottoResult matchAnswer) {
        String bonusInfo = "";
        if (prize.isSecond()) {
            bonusInfo = Message.BONUS_BALL_MESSAGE.message();
        }
        System.out.printf("%d개 일치" + bonusInfo + "(%d원)- %d개\n", prize.matchingCount(), money, matchAnswer.count(prize));
    }

    private static void printIncome(LottoResult lottoResult, Money money) {
        System.out.printf(Message.INCOME_PREFIX.message() + "%.2f" + Message.INCOME_POSTFIX.message() + "%n", (float) lottoResult.income() / money.amount());
    }
}