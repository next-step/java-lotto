package lotto.view;

import lotto.Insights;
import lotto.domain.Lotto;
import lotto.domain.LottoPaper;
import java.util.List;
import java.util.Map;

public class ResultView {

    public static void printLottoNumber(LottoPaper lottoPaper) {
        List<Lotto> lottos = lottoPaper.getLottoPapers();
        for (Lotto lotto : lottos) {
            System.out.println(lotto.getLottoNumber());
        }
    }

    public static void printDescription() {
        System.out.println("당첨 통계");
        System.out.println("---------");
    }

    public static void printInsights(Map<Integer, Insights> insights) {
        for (Map.Entry<Integer, Insights> entry : insights.entrySet()) {
            printWinningInsights(entry);
        }
    }

    private static void printWinningInsights(Map.Entry<Integer, Insights> entry) {
        if (entry.getKey() >= 3) {
            System.out.println(entry.getKey() + "개 일치"
                    + "(" + entry.getValue().getPrice() + "원) - " + entry.getValue().getCount() + "개");
        }
    }

    public static void printYield(double yield) {
        System.out.println("총 수익률은 " + Double.parseDouble(String.format("%.2f", yield))+ "입니다");
    }
}