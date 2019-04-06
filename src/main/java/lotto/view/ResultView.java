package lotto.view;

import lotto.vo.LotteryGenerator;
import lotto.vo.Money;
import lotto.vo.Rank;

import java.util.Map;

public class ResultView {
    public static final int WIN_RATE = 1;

    public void printPurchaseTicketCount(Money money) {
        int tickets = money.buyingTicketCount();
        System.out.println(String.format("%s개를 구매했습니다.", tickets));
        lotteryGenerator(money);
    }

    private void lotteryGenerator(Money money) {
        new LotteryGenerator().lotteryGenerator(money);
    }

    public void winningNumberStatistics(Map<Rank, Integer> ranks) {
        System.out.println("당첨통계");
        System.out.println("---------");
        printNumberOfWinningCount(Rank.FOURTH_PLACE, ranks);
        printNumberOfWinningCount(Rank.THIRD_PLACE, ranks);
        printNumberOfWinningCount(Rank.SECOND_PLACE, ranks);
        printNumberOfWinningCount(Rank.FIRST_PLACE, ranks);
    }

    public void printNumberOfWinningCount(Rank rank, Map<Rank, Integer> ranks) {
        System.out.println(perStatistics(rank.getNumberOfMatches(), rank.getReward(), ranks.get(rank) == null ? 0 : ranks.get(rank)));
    }

    public String perStatistics(int matchedNumber, int winningAmount, int winningNumber) {
        return String.format("%d개 일치(%d원)- %d개", matchedNumber, winningAmount, winningNumber);
    }

    public void revenueRate(double rate) {
        String benefitResult = rate >= WIN_RATE ? "이득이" : "손해";
        System.out.println(String.format("총 수익률은 %s입니다.(기준이 1이기 때문에 결과적으로 %s라는 의미임)", String.valueOf(rate), benefitResult));
    }
}
