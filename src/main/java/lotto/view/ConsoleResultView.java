package lotto.view;

import lotto.domain.Lottos;
import lotto.domain.LottosResult;
import lotto.domain.Ranking;

public class ConsoleResultView implements ResultView {
    @Override
    public void showLottos(Lottos lottos) {
        lottos.lottos().forEach(lotto -> System.out.println(lotto.lotto()));
        System.out.println();
    }

    @Override
    public void winningStats(LottosResult lottosResult) {
        printStatGuide();

        printRankingStat(lottosResult);
        printProfitRate(lottosResult);
        printIsLoss(lottosResult);
    }

    private void printIsLoss(LottosResult lottosResult) {
        if (lottosResult.isLoss()) {
            System.out.print("(기준이 1이기 때문에 결과적으로 손해라는 의미임.)");
        }
    }

    private void printProfitRate(LottosResult lottosResult) {
        System.out.println("총 수익률은 " + lottosResult.profitRate() + "입니다.");
    }

    private void printRankingStat(LottosResult lottosResult) {
        for (Ranking ranking : Ranking.ranked()) {
            System.out.print(ranking.matchingCount() + "개 일치(" + ranking.profit() + "원)- ");
            System.out.print(lottosResult.countByRanking(ranking) + "개");
            System.out.println();
        }
    }

    private void printStatGuide() {
        System.out.println("당첨 통계");
        System.out.println("--------");
    }
}
