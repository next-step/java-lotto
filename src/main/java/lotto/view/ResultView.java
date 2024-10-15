package lotto.view;

import lotto.domain.LottoCashPrize;
import lotto.domain.LottoNumbers;
import lotto.domain.LottoNumbersResults;

import java.util.List;

import static lotto.domain.LottoCashPrize.getValuablePrizes;

public class ResultView {
    public static void printLottoSheetCount(int lottoSheetCount) {
        System.out.println(lottoSheetCount + "개를 구매했습니다.");
    }

    public static void printLottoSheets(List<LottoNumbers> lottoNumbersList) {
        lottoNumbersList.forEach(lottoNumbers -> System.out.println(lottoNumbers.getLottoNumbers()
                .toString()));
        System.out.println();
    }

    public static void printLottoResults(LottoNumbersResults lottoSheetResults) {
        printLottoResultsHeader();

        for (LottoCashPrize lottoCashPrize : getValuablePrizes()) {
            int sheetMatchCount = lottoSheetResults.getValue()
                    .getOrDefault(
                            lottoCashPrize,
                            0
                    );

            System.out.println(
                    lottoCashPrize.getMatchedCount() + "개 일치 (" + lottoCashPrize.getPrize() + "원)- " + sheetMatchCount + "개");
        }
    }

    private static void printLottoResultsHeader() {
        System.out.println();
        System.out.println("당첨 통계");
        System.out.println("---------");
    }

    public static void printLottoProfits(int payment, LottoNumbersResults lottoSheetResults) {
        System.out.println(
                "총 수익률은 " + Math.floor(lottoSheetResults.sumCashPrizes() / (double) payment * 100) / 100 + "입니다.");
    }
}
