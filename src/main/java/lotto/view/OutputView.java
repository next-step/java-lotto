package lotto.view;

import java.util.Iterator;
import java.util.List;
import java.util.Map;
import lotto.domain.Lotto;
import lotto.domain.Rank;

public class OutputView {
    
    private static final String BONUS_BALL = ", 보너스 볼 일치";
    private static final String LOSS = "(기준이 1이기 때문에 결과적으로 손해라는 의미임)";
    private static final String WINNING_STATISTICS_MESSAGE = "\n당첨 통계\n---------";
    private static final int ZERO = 0;
    
    public static void outputLottoCount(int count, int manualCount) {
        System.out.printf("수동으로 %d장, 자동으로 %d개를 구매했습니다.\n", manualCount, count - manualCount);
    }
    
    public static void printLottos(List<Lotto> lottos) {
        lottos.forEach(lotto -> System.out.println(lotto.getNumbers()));
    }
    
    public static double printResult(Map<Rank, Integer> ranks) {
        System.out.println(WINNING_STATISTICS_MESSAGE);
        return printRanks(ranks);
    }
    
    public static void printYield(double yield) {
        String loss = "";
        if (yield == ZERO) {
            loss = LOSS;
        }
        System.out.print("총 수익률 " + yield + "입니다." + loss);
    }
    
    private static double printRanks(Map<Rank, Integer> ranks) {
        Iterator<Rank> keys = ranks.keySet().iterator();
        double money = 0;
        while (keys.hasNext()) {
            Rank key = keys.next();
            money += printRank(ranks, key);
        }
        return money;
    }
    
    private static double printRank(Map<Rank, Integer> ranks, Rank key) {
        if (key == Rank.SECOND) {
            return printSecond(ranks, key);
        }
        System.out.println(
          key.getMatchCount() + "개 일치 (" + key.getReward() + ")- " + ranks.get(key)
            + "개");
        return key.getReward() * ranks.get(key);
    }
    
    private static double printSecond(Map<Rank, Integer> ranks, Rank key) {
        System.out.println(
          key.getMatchCount() + "개 일치" + BONUS_BALL + "(" + key.getReward() + ")- " + ranks.get(key)
            + "개");
        return key.getReward() * ranks.get(key);
    }
}

