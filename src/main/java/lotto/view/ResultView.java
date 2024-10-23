package lotto.view;

import java.util.stream.Collectors;
import lotto.domain.Lotto;
import lotto.domain.LottoResultStatistic;
import lotto.domain.Lottos;
import lotto.domain.Prize;
import lotto.domain.PurchaseInfo;

public class ResultView {

    public void printPurchaseLottoResult(Lottos lottos) {
        NumberOfLotto(lottos.getPurchaseInfo());
        printPurchasedLottos(lottos);
    }

    private void NumberOfLotto(PurchaseInfo purchaseInfo) {
        System.out.println("\n수동으로 " + purchaseInfo.getNumberOfManualPurchase() +
                "장, 자동으로 " + purchaseInfo.getNumberOfAutoPurchase() + "개를 구매했습니다");
    }

    private void printPurchasedLottos(Lottos lottos) {
        for (Lotto lotto : lottos.getLottos()) {
            System.out.println(
                    lotto.getLotto()
                            .stream()
                            .map(i -> String.valueOf(i.getLottoNumber()))
                            .collect(Collectors.joining(", ", "[", "]"))
            );
        }

    }

    public void printResult(LottoResultStatistic lottoResultStatistic, PurchaseInfo purchaseInfo) {
        printStatistic(lottoResultStatistic);
        printProfit(lottoResultStatistic.calculateProfit(purchaseInfo.getPruchaseAmount()));
    }

    private static void printStatistic(LottoResultStatistic lottoResultStatistic) {
        System.out.println();
        System.out.println("당첨 통계");
        System.out.println("---------");
        System.out.println("3개 일치 (5000원)- " + lottoResultStatistic.getPrizeFromStatistic(Prize.FIFTH));
        System.out.println("4개 일치 (50000원)- " + lottoResultStatistic.getPrizeFromStatistic(Prize.FOURTH));
        System.out.println("5개 일치 (1500000원)- " + lottoResultStatistic.getPrizeFromStatistic(Prize.THIRD));
        System.out.println("5개 일치, 보너스볼 일치(30000000원)- " + lottoResultStatistic.getPrizeFromStatistic(Prize.SECOND));
        System.out.println("6개 일치 (2000000000원)- " + lottoResultStatistic.getPrizeFromStatistic(Prize.FIRST));
    }

    public void printProfit(double profitRate) {
        if (profitRate < 1) {
            System.out.println("총 수익률은 " + profitRate + "입니다.(기준이 1이기 때문에 결과적으로 손해라는 의미임)");
            return;
        }
        System.out.println("총 수익률은 " + profitRate + "입니다.(기준이 1이기 때문에 결과적으로 이득라는 의미임)");
    }


}
