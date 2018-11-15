package lotto.view;

import lotto.model.Lotto;
import lotto.model.PrizePrice;
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

        for (int i = 3; i <= 6; i++) {
            System.out.println(i + "개 일치 (" + PrizePrice.getPrice(i) + "원)- " + statisticsService.getMatchCount(i) + "개");
        }
    }

    public static void printReturnsOfInvestment(PrizeStatisticsService statisticsService, int money) {
        System.out.println("총 수익률은 " + statisticsService.getReturnsOfInvestment(money) + "입니다.");
    }
}
