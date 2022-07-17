package lotto.view;

import lotto.domain.LotteryGames;
import lotto.domain.LotteryNumber;
import lotto.domain.Rank;
import lotto.interfaces.LotteryGame;

import java.util.Map;

public class ResultView {

    public static void print(LotteryGames purchasedLotteryGames) {
        StringBuilder stringBuilder = new StringBuilder();
        for (LotteryGame lotteryGame : purchasedLotteryGames.getLotteryGameList()) {
            appendLotteryNumber(stringBuilder, lotteryGame);
        }
        System.out.println(stringBuilder.toString());
    }

    private static void appendLotteryNumber(StringBuilder stringBuilder, LotteryGame lotteryGame) {
        stringBuilder.append("[");
        for (LotteryNumber lottery : lotteryGame.getLotteries()) {
            stringBuilder.append(lottery.getNumber()).append(", ");
        }
        stringBuilder.deleteCharAt(stringBuilder.lastIndexOf(","));
        stringBuilder.deleteCharAt(stringBuilder.lastIndexOf(" "));
        stringBuilder.append("]\n");
    }

    public static void printResult(Map<Rank, Integer> results) {
        System.out.println("당첨 통계");
        System.out.println("---------");

        for (Rank rank : results.keySet()) {
            if (Rank.SECOND == rank) {
                System.out.println(rank.getCountOfMatch() + "개 일치, 보너스 볼 일치 (" + rank.getWinningMoney()+ "원)- " + results.get(rank) + "개");
                continue;
            }
            System.out.println(rank.getCountOfMatch() + "개 일치 (" + rank.getWinningMoney()+ "원)- " + results.get(rank) + "개");
        }
    }

    public static void printProfit(double profitRate) {
        System.out.println("총 수익률은 " + profitRate + "입니다. (기준이 1이기 때문에 결과적으로 손해라는 의미임)");
    }
}
