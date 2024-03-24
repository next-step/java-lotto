package lotto.view;

import lotto.MatchedCount;
import lotto.RANK;
import lotto.RankMap;

import java.util.Map;

public class StatisticView {

    public void viewWinningLottos(RankMap rankMap) {
        Map<MatchedCount, Integer> map = rankMap.getMap();

        System.out.println("당첨 통계");
        System.out.println("---------");
        map.forEach((k,v) -> System.out.println(String.format("%s개 일치 (%s) - %s개", k, RANK.getPrizeMoney(k), v)));
    }
}
