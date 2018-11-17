package lotto.view;

import lotto.model.Lotto;
import lotto.model.Rank;
import lotto.service.PrizeStatisticsService;

import java.util.List;

public class ResultView {

    public static void printBoughtHistory(List<Lotto> lottos) {
        System.out.println(lottos.size() + "개를 구매했습니다.");

        for (Lotto lotto : lottos) {
            System.out.println(lotto.toString());
        }
    }

    public static void printStatisticsOfPrize(PrizeStatisticsService statisticsService) {
        System.out.println("당첨 통계");
        System.out.println("---------");

        System.out.println("3개 일치 (" + Rank.valueOf(3, false).getWinningMoney() + "원)- " + Rank.valueOf(3, false).getCountOfMatch() + "개");
        System.out.println("4개 일치 (" + Rank.valueOf(4, false).getWinningMoney() + "원)- " + Rank.valueOf(4, false).getCountOfMatch() + "개");
        System.out.println("5개 일치 (" + Rank.valueOf(5, false).getWinningMoney() + "원)- " + Rank.valueOf(5, false).getCountOfMatch() + "개");
        System.out.println("5개 일치 (" + Rank.valueOf(5, true).getWinningMoney() + "원)- " + Rank.valueOf(5, true).getCountOfMatch() + "개");
        System.out.println("6개 일치 (" + Rank.valueOf(6, false).getWinningMoney() + "원)- " + Rank.valueOf(6, false).getCountOfMatch() + "개");
    }

    public static void printReturnsOfInvestment(PrizeStatisticsService statisticsService, int money) {
        System.out.println("총 수익률은 " + statisticsService.getReturnsOfInvestment(money) + "입니다.");
    }
}
