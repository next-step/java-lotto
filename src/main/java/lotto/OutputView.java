package lotto;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import lotto.domain.Lotto;
import lotto.domain.MatchCount;
import lotto.domain.WinningResult;

public class OutputView {

    private OutputView() {
    }

    public static void printPurchaseResult(int purchaseAmount, List<Lotto> lottos) {
        System.out.println(purchaseAmount + "개를 구매했습니다.");
        for (Lotto lotto : lottos) {
            System.out.println(lotto.getNumbers());
        }
    }

    public static void printStatistics(WinningResult result) {
        System.out.println("\n당첨 통계\n---------");

        List<MatchCount> matchCounts = Arrays.stream(MatchCount.values())
            .filter(match -> match != MatchCount.NONE)
            .collect(Collectors.toList());

        for (MatchCount match : matchCounts) {
            int count = result.countByMatch(match);
            System.out.println(
                match.getMatchCount() + "개 일치 (" + match.getPrize() + "원)- " + count + "개");
        }
    }

    public static void printProfitRate(BigDecimal profitRate) {
        System.out.println("총 수익률은 " + profitRate + "입니다.(기준이 1이기 때문에 결과적으로 " +
            (profitRate.compareTo(BigDecimal.ONE) >= 0 ? "이익" : "손해") + "라는 의미임)");
    }
}
