package lotto.view;

import lotto.domain.Lotto;
import lotto.domain.LottoBundle;
import lotto.domain.LottoResult;
import lotto.util.ProfitCalculator;

import java.util.List;
import java.util.Map;

public class ResultView {

    public static void printPurchaseInfo(LottoBundle lottoBundle) {
        System.out.println(String.format("%d개를 구매했습니다.", lottoBundle.lottoCount()));
        printLottoNumbers(lottoBundle.lottoList());
    }

    private static void printLottoNumbers(List<Lotto> lottoList) {
        for (Lotto lotto : lottoList) {
            System.out.println(lotto.numbers().toString());
        }
        System.out.println();
    }

    public static void printWinningStatistics(int purchasePrice, Map<LottoResult, Integer> lottoResults) {
        System.out.println("당첨 통계");
        System.out.println("---------");

        long profitPrice = 0;

        lottoResults.remove(LottoResult.FAIL);
        for (Map.Entry<LottoResult, Integer> entry : lottoResults.entrySet()) {
            LottoResult lottoResult = entry.getKey();
            int count = entry.getValue();
            profitPrice += lottoResult.prize() * count;
            System.out.println(
                    String.format("%d개 일치%s (%d원) - %d개",
                            lottoResult.matchCount(),
                            lottoResult.matchBonus() ? ", 보너스 볼 일치" : "",
                            lottoResult.prize(),
                            count)
            );
        }

        System.out.println(String.format("총 수익률은 %.2f입니다.", ProfitCalculator.calculateProfitRate(purchasePrice, profitPrice)));
    }

}
