package lotto.view;

import java.util.List;
import java.util.Map.Entry;

import lotto.model.Lotto;
import lotto.model.Match;
import lotto.model.Result;

public final class ResultView {

    private static final StringBuilder stringBuilder = new StringBuilder();

    private ResultView() {
    }

    public static void printLottos(List<Lotto> lottos) {
        lottos.forEach(lotto -> stringBuilder.append(lotto + "\n"));
        System.out.println(stringBuilder);
    }

    public static void printResult(int purchasedAmount, Result result) {
        stringBuilder.setLength(0);
        stringBuilder.append("당첨 통계\n---------\n");
        result.getMatchedCounts()
              .entrySet()
              .forEach(entry -> printEachMatch(entry));

        stringBuilder.append("총 수익률은 " + result.calculateRatio(purchasedAmount) + "입니다.");
        System.out.println(stringBuilder);
    }

    private static void printEachMatch(Entry<Match, Integer> entry) {
        Match match = entry.getKey();
        stringBuilder.append(match.getMatchedCount() + "개 일치 (" + match.getPrice() + "원) - " + entry.getValue() + "개\n");
    }
}
