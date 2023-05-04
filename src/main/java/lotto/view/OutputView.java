package lotto.view;

import lotto.model.LotteryTickets;
import lotto.model.Win;

import java.util.Map;

public class OutputView {

    public static void showLotteryCount(int count) {
        System.out.println(count + "개를 구매했습니다.");
    }

    public static void showLotteryTickets(LotteryTickets lotteryTickets) {
        lotteryTickets.getTickets().forEach(System.out::println);
        System.out.println();
    }

    public static void showResult(Map<Win, Integer> winTotal, int outcome) {
        System.out.println();
        System.out.println("당첨 통계");
        System.out.println("---------");
        for (int i = 0; i < Win.values().length; i++) {
            System.out.println(Win.values()[i].getPoints() + "개 일치 (" + Win.values()[i].getPrize() + "원)- " + winTotal.get(Win.values()[i]));
        }

        int income = Win.totalMoney(winTotal);
        System.out.println("총 수익률은 " + Win.calculateProfitRate(income, outcome) + "입니다.");
    }

}
