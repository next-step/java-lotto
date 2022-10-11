package lotto.view;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Map;

import lotto.domain.Lotto;
import lotto.Prize;

public class OutputView {


    public void printPurchasedLotto(List<Lotto> lottos) {
        System.out.println(lottos.size() + "개 구매했습니다.");
        for (Lotto lotto : lottos) {
            System.out.println("[" + lotto.printNumber() + "]");
        }
    }

    public void printStatisticLotto(Map<Integer, Integer> rankMap) {
        System.out.println("당첨 통계");
        System.out.println("---------");
        printRank(rankMap);
    }

    public void printYield(double yield) {
        System.out.println(
                "총 수익률은 " + String.format("%.3f", yield) +
                "입니다.");
    }

    private void printRank(Map<Integer, Integer> rankMap) {
        Arrays.stream(Prize.values()).sorted(Comparator.comparing(Prize::getWinningCount)).forEach(p -> {
            System.out.println(p.getWinningCount() + "개 일치 (" + p.getPrizeMoney() + "원) - " +
                               rankMap.get(p.getWinningCount()) + "개");
        });
    }
}
