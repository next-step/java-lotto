package Lotto.view;

import Lotto.domain.*;

import java.util.Arrays;
import java.util.stream.Collectors;

public class ConsoleOutputView implements OutputViewInterface {
    @Override
    public void printPrompt(String prompt) {
        System.out.println(prompt);
    }

    @Override
    public void printTicketCount(int manualCount, int autoCount) {
        System.out.printf("수동으로 %d장, 자동으로 %d개를 구매했습니다.\n", manualCount, autoCount);
    }

    @Override
    public void printLottos(Lottos lottos) {
        for (Lotto lottoTicket : lottos.getLottos()) {
            System.out.println(lottoTicket);
        }
    }

    @Override
    public void printResultStats(ResultStats stats, int totalSpent) {
        System.out.println("당첨 통계");
        System.out.println("---------");
        printResult(stats);
        printProfit(stats.calculateProfitRate(totalSpent)); // 'totalSpent'은 사용자가 로또 구입에 소비한 총 금액
    }

    private static void printResult(ResultStats stats) {
        for (Rank rank : Arrays.stream(Rank.values()).filter(r -> r != Rank.MISS).collect(Collectors.toList())) {
            String bonusText = getBonusText(rank);
            System.out.printf(
                    "%d개 일치%s (%s)- %d개\n",
                    rank.getCountOfMatch(),
                    bonusText,
                    formatMoney(rank.getWinningMoney()),
                    stats.getCountByRank(rank)
            );
        }
    }

    private static String getBonusText(Rank rank) {
        if (rank == Rank.SECOND) {
            return ", 보너스 볼 일치";
        }
        return "";
    }

    private static String formatMoney(int amount) {
        return String.format("%,d원", amount);
    }

    private static void printProfit(double profit) {
        System.out.print("총 수익률은 " + formatProfit(profit) + "입니다.");
        if (profit < 1) {
            System.out.println("(기준이 1이기 때문에 결과적으로 손해라는 의미임)");
        }
    }

    private static String formatProfit(double profit) {
        return String.format("%.2f", profit);
    }
}
