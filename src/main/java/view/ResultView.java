package view;

import domain.Lotto;
import domain.LottoPrizeType;
import domain.WinningStatistics;

import java.util.HashMap;
import java.util.List;

public class ResultView {

    public static void purchaseResult(int purchaseCount) {
        System.out.println(purchaseCount + "개를 구매했습니다.");
    }

    public static void lottoNumberResult(List<Lotto> lottoList) {
        for (Lotto lotto : lottoList) {
            System.err.println(lotto.getNumbers().getValues());
        }
    }

    public static void winningResult(WinningStatistics winningStatistics) {
        System.out.println("당첨통계");
        System.out.println("---------");
        HashMap<LottoPrizeType, Integer> winningStatistic = winningStatistics.getWinningStatistic();
        for (LottoPrizeType lottoPrizeType : winningStatistic.keySet()) {
            System.out.println(lottoPrizeType.getMatchCount() +
                    "개 일치 " + "(" + lottoPrizeType.getWinningAmount() + "원) - "
                    + winningStatistic.get(lottoPrizeType) + "개");
        }
    }

    public static void yieldResult(double lottoYield) {
        System.out.print("총 수익률은 " + lottoYield + "입니다.");
        if (lottoYield < 1) {
            System.out.println("(기준이 1이기 때문에 결과적으로 손해라는 의미임)");
        }
        if (lottoYield >= 1) {
            System.out.println("(기준이 1이기 때문에 결과적으로 이득라는 의미임)");
        }
    }
}
