package lotto.view;

import lotto.MatchedCount;
import lotto.Rank;
import lotto.RankMap;

import java.util.Map;

public class StatisticView {

    public void viewWinningLottos(RankMap rankMap) {
        Map<MatchedCount, Integer> map = rankMap.getMap();

        System.out.println("당첨 통계");
        System.out.println("---------");
        map.forEach(StatisticView::getPrintln);
    }

    private static void getPrintln(MatchedCount k, Integer v) {
        if (k.isBonusMatched()) {
            System.out.println(String.format("%s개 일치, 보너스 볼 일치 (%s원) - %s개", k, Rank.getPrizeMoney(k), v));
            return;
        }
        System.out.println(String.format("%s개 일치 (%s원) - %s개", k, Rank.getPrizeMoney(k), v));
    }
}
