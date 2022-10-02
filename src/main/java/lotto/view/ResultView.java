package lotto.view;

import lotto.domain.LottoNumber;
import lotto.domain.Purchase;
import lotto.domain.WinningPrize;
import lotto.domain.WinningResult;

import java.util.List;

public class ResultView {

    private ResultView() {}

    public static void availablePurchasePrint(final long count) {

        System.out.printf("%d개를 구매했습니다.", count);
    }

    public static void autoLottoNumberPrint(final List<LottoNumber> lottoNumbers) {

        blank();
        for (LottoNumber lottoNumber : lottoNumbers) {
            System.out.println(lottoNumber);
        }
    }

    public static void winningResultPrint(final WinningResult winningResult) {

        winningStatisticsTitlePrint();
        for (Integer rank : WinningPrize.init().keySet()) {
            final WinningPrize winningPrice = WinningPrize.from(rank);
            int resultCount = winningResult.getResultCount(winningPrice);
            resultStepPrint(winningPrice, resultCount);
            blank();
        }
    }

    private static void winningStatisticsTitlePrint() {

        System.out.println("당첨 통계");
        System.out.println("---------");
    }

    private static void resultStepPrint(final WinningPrize winningPrice, final int rankCount) {

        System.out.printf("%d개 일치 (%s원)- %d개", winningPrice.getCountOfMatch(), winningPrice.getPrice(), rankCount);
    }

    public static void winningPrizeRatePrint(final Purchase purchase) {

        System.out.printf("총 수익률은 %s 입니다." + check(purchase), purchase.getRate());
    }

    private static String check(final Purchase purchase) {

        if (purchase.profit()) {
            return "";
        }
        return "(기준이 1이기 때문에 결과적으로 손해라는 의미임)";
    }

    private static void blank() {

        System.out.println();
    }
}
