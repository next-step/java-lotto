package step2;

import java.util.HashMap;
import java.util.List;

public class ResultView {

    private static final HashMap<Integer, Integer> matchMap = new HashMap<>();

    static {
        matchMap.put(3, 0);
        matchMap.put(4, 0);
        matchMap.put(5, 0);
        matchMap.put(6, 0);
    }

    public static void showLottoUnitCount(int unitCount) {
        System.out.println(unitCount + "개를 구매했습니다.");
    }

    public static void showLottoUnitDetail(List<Lotto> lottos) {
        for (Lotto lotto : lottos) {
            System.out.println(lotto);
        }
    }

    public static void showWinningStats(List<Lotto> lottos, Lotto lastWeekWinningLotto, LottoPrice lottoPrice) {
        System.out.println("당첨 통계\n" + "---------");

        for (Lotto lotto : lottos) {
            int matchCount = lotto.getMatchCount(lastWeekWinningLotto);
            calcMatchCount(matchCount);
        }
        System.out.println(String.format("3개 일치 (5000원)- %d개", matchMap.get(3)));
        System.out.println(String.format("4개 일치 (50000원)- %d개", matchMap.get(4)));
        System.out.println(String.format("5개 일치 (1500000원)- %d개", matchMap.get(5)));
        System.out.println(String.format("6개 일치 (2000000000원)- %d개", matchMap.get(6)));
        System.out.println(String.format("총 수익률은 %.2f입니다.", lottoPrice.calcYield(matchMap)));
    }

    private static void calcMatchCount(int matchCount) {
        if (matchMap.containsKey(matchCount)) {
            matchMap.replace(matchCount, matchMap.get(matchCount) + 1);
        }
    }
}
