package lotto.view;

import java.util.List;
import java.util.Map.Entry;

import lotto.model.Lotto;
import lotto.model.Money;
import lotto.model.Rank;
import lotto.model.Result;

public final class ResultView {

    private static final StringBuilder stringBuilder = new StringBuilder();

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
        stringBuilder.append("총 수익률은 " + result.calculateRatio(purchasedAmount.getMoney()) + "입니다.");
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
}
