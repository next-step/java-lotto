package lotto.view;

import lotto.Rank;
import lotto.domain.Lotto;
import lotto.domain.Lottos;
import lotto.domain.Money;
import lotto.domain.Ranks;

import java.util.List;
import java.util.Map;

public class ResultView {
    private static final double YIELD_PIVOT_NUMBER = 1.0;

    public static void printLottoNumber(Lottos purchasedLotto) {
        List<Lotto> lottos = purchasedLotto.getLottos();
        for (Lotto lotto : lottos) {
            System.out.println(lotto.getLottoNumber());
        }
    }

    public static void printLottoResult(Ranks ranks) {
        printDescription();
        for (Map.Entry<Rank, Integer> entry : ranks.updateLottoRank().entrySet()) {
            System.out.println(printLotto(entry));
        }
    }

    public static void getYield(Ranks ranks, Money money) {
        double yield = (double) ranks.getTotalLottoWinningPrice() / money.getPurchaseAmount();
        System.out.println(printYield(yield));
    }

    private static String printYield(double yield) {
        if (yield >= YIELD_PIVOT_NUMBER) {
            return String.format("총 수익율은 %s입니다.", Double.parseDouble(String.format("%.2f", yield)));
        }
        return String.format("총 수익율은 %s입니다. (기준이 1이기 때문에 결과적으로 손해라는 의미임",
                Double.parseDouble(String.format("%.2f", yield)));
    }

    private static String printLotto(Map.Entry<Rank, Integer> entry) {
        if (entry.getKey() == Rank.SECOND) {
            return String.format("%s 개 일치, 보너스 볼 일치(%d원)- %d개",
                    entry.getKey().getCountOfMatch(), entry.getKey().getWinningMoney(), entry.getValue());
        }
        return String.format("%s 개 일치 (%d원)- %d개",
                entry.getKey().getCountOfMatch(), entry.getKey().getWinningMoney(), entry.getValue());
    }

    private static void printDescription() {
        System.out.println("당첨 통계");
        System.out.println("---------");
    }
}