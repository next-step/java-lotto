package lotto.view;

import java.util.List;
import java.util.Map.Entry;

import lotto.model.Lotto;
import lotto.model.Money;
import lotto.model.Rank;
import lotto.model.Result;

public final class ResultView {

    private static final StringBuilder stringBuilder = new StringBuilder();
    private static final int BREAK_EVEN_POINT = 1;

    private ResultView() {
    }

    public static void printInput(List<Lotto> lottos, Money purchasedAmount) {
        stringBuilder.setLength(0);
        printPurchasedCount(purchasedAmount);
        printEachLotto(lottos);
        System.out.println(stringBuilder);
    }

    private static void printPurchasedCount(Money purchasedAmount) {
        stringBuilder.append(purchasedAmount.getLottoCount())
                     .append("개를 구매했습니다.\n");
    }

    private static void printEachLotto(List<Lotto> lottos) {
        lottos.forEach(lotto -> stringBuilder.append(lotto + "\n"));
    }

    public static void printResult(Money purchasedAmount, Result result) {
        stringBuilder.setLength(0);
        stringBuilder.append("당첨 통계\n---------\n");
        printRanks(result);
        Double ratio = purchasedAmount.calculateRatio(result.calculateWinningAmount());
        stringBuilder.append("총 수익률은 " + ratio + "입니다.");
        stringBuilder.append(printProfitableOrNot(ratio));
        System.out.println(stringBuilder);
    }

    private static void printRanks(Result result) {
        result.getRanks()
              .entrySet()
              .stream()
              .filter(entry -> entry.getKey() != Rank.MISS)
              .forEach(entry -> printEachRank(entry));
    }

    private static void printEachRank(Entry<Rank, Integer> entry) {
        Rank rank = entry.getKey();
        stringBuilder.append(rank.getMatchedCount() + "개 일치");
        if (rank == Rank.SECOND) {
            stringBuilder.append(", 보너스 볼 일치");
        }
        stringBuilder.append(" (" + rank.getPrice() + "원) - " + entry.getValue() + "개\n");
    }

    private static String printProfitableOrNot(Double ratio) {
        if (ratio < BREAK_EVEN_POINT) {
            return "(기준이 1이기 때문에 결과적으로 손해라는 의미임)";
        }
        return "(기준이 1이기 때문에 이득이라는 의미)";
    }
}
