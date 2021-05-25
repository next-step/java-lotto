package lotto.ui;

import lotto.enums.MessageEnum;
import lotto.enums.PrizeEnum;
import lotto.lotto.Lotto;
import lotto.lotto.LottoNumber;
import lotto.lotto.LottoTicket;
import lotto.lotto.LottoResult;
import lotto.shop.Money;

import java.util.stream.Collectors;

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

    public static void printLottoTicket(LottoTicket lottoTicket) {
        for(Lotto lotto : lottoTicket.tickets()) {
            printLotto(lotto);
        }
    }

    public static void resultMessage() {
        println(MessageEnum.RESULT.message());
        println(MessageEnum.LINE.message());
    }

    public static void resultIncome(LottoResult lottoResult, Money money) {
        for (PrizeEnum prizeValue : PrizeEnum.values()) {
            printLottoResult(prizeValue, prizeValue.prize(), lottoResult);
        }
        printIncome(lottoResult, money);
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

    private static void printLottoResult(PrizeEnum prizeEnum, int prize, LottoResult matchAnswer) {
        System.out.printf("%d개 일치 (%d원)- %d개\n", prizeEnum.matchingCount(), prize, matchAnswer.count(prizeEnum));
    }

    private static void printIncome(LottoResult lottoResult, Money money) {
        System.out.printf(MessageEnum.INCOME_PREFIX.message() + "%.2f" + MessageEnum.INCOME_POSTFIX.message() + "%n", (float) lottoResult.income() / money.amount());
    }
}