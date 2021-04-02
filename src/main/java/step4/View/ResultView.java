package step4.View;


import step4.*;

import java.util.Map;

public class ResultView {

    public void printInteger(Lotto lotto) {
        System.out.println(lotto);
    }

    public void printPassiveAndAuto(int auto, int passive) {
        System.out.println("수동으로 " + passive + "장, 자동으로 " + auto + "장 구매했습니다.");
    }

    public void printSameLotto(Map<Rank, Integer> statistic) {
        System.out.println("당첨 통계");
        System.out.println("---------");
        for (Rank rank : statistic.keySet()) {
            System.out.println(rank.getCountOfMatch() + "개 일치 (" + rank.getWinningMoney() + ")- "
                    + statistic.get(rank) + "개");
        }
    }
    public void printBenefit(LottoYield calculator, Price price) {
        System.out.println("총 수익률은 " + calculator.benefit(price) + "입니다.");
    }

}
