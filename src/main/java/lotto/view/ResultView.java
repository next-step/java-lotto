package lotto.view;

import lotto.domain.Lotto;
import lotto.domain.WinningType;

import java.util.List;
import java.util.Map;


public class ResultView {

    public static void printPurchaseNumber(int number) {
        System.out.println(number + Message.PURCHASE_NUMBER.message);
    }

    public static void printGeneratedLottos(int numberOfManualLottoTicket,
                                            int numberOfAutoLottoTicket,
                                            List<Lotto> lottos) {
        System.out.println(String.format(Message.PURCHASE_LOTTOS.message, numberOfManualLottoTicket, numberOfAutoLottoTicket));
        for (Lotto lotto : lottos) {
            System.out.println(lotto.getLottoNumbers().toString());
        }
    }

    public static void printResult(Map<WinningType, Integer> matchResult, int money, float profitRate) {
        System.out.println("");
        System.out.println(Message.STATISTIC_HEADER.message);
        for (WinningType winningType : WinningType.values()) {
            printEachResult(matchResult, winningType);
        }

        System.out.println(String.format(Message.STATISTIC_REVENUE.message, profitRate));
    }

    private static void printEachResult(Map<WinningType, Integer> matchResult, WinningType winningType) {
        if (winningType.getValue() == 0) {
            return;
        }
        if (winningType == WinningType.FIVE_BONUS) {
            System.out.println(String.format(Message.FIVE_BONUS_COUNT.message,
                    winningType.getValue(), winningType.getProfit().getValue(), matchResult.get(winningType)));
            return;
        }
        System.out.println(String.format(Message.WINNER_COUNT.message,
                winningType.getValue(), winningType.getProfit().getValue(), matchResult.get(winningType)));
    }
}
