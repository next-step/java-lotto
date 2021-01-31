package lotto.view;

import lotto.domain.Lotto;
import lotto.domain.LottoMachine;
import lotto.domain.WinningType;

import java.util.List;
import java.util.Map;

public class ResultView {
    private static final String PURCHASE_NUMBER_MESSAGE = "개를 구입했습니다.";
    private static final String STATISTIC_HEADER_MESSAGE = "당첨 통계\n---------";
    private static final String WINNER_COUNT_MESSAGE = "%d개 일치 (%d원)- %d개";
    private static final String FIVE_BONUS_COUNT_MESSAGE = "%d개 일치, 보너스 볼 일치(%d원)- %d개";
    private static final String STATISTIC_REVENUE_MESSAGE = "총 수익률은 %.2f입니다.";

    public static void printPurchaseNumber(int number) {
        System.out.println(number + PURCHASE_NUMBER_MESSAGE);
    }

    public static void printGeneratedLottos(List<Lotto> lottos) {
        for (Lotto lotto : lottos) {
            System.out.println(lotto.getLottoNumbers().toString());
        }
    }

    public static void printResult(Map<WinningType, Integer> matchResult, int money) {
        System.out.println("");
        System.out.println(STATISTIC_HEADER_MESSAGE);
        for (WinningType winningType : WinningType.values()) {
            printEachResult(matchResult, winningType);
        }

        float profitRate = LottoMachine.getProfitRate(matchResult, money);
        System.out.println(String.format(STATISTIC_REVENUE_MESSAGE, profitRate));
    }

    private static void printEachResult(Map<WinningType, Integer> matchResult, WinningType winningType) {
        if (winningType.getValue() == 0) {
            return;
        }
        if (winningType == WinningType.FIVE_BONUS) {
            System.out.println(String.format(FIVE_BONUS_COUNT_MESSAGE,
                    winningType.getValue(), winningType.getProfit(), matchResult.get(winningType)));
            return;
        }
        System.out.println(String.format(WINNER_COUNT_MESSAGE,
                winningType.getValue(), winningType.getProfit(), matchResult.get(winningType)));
    }
}
