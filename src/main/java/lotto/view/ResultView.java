package lotto.view;

import lotto.domain.*;

import java.util.List;
import java.util.Map;

import static lotto.domain.LottoSheetResults.LOTTO_CASH_PRIZES;

public class ResultView {
    public static void printLottoSheetCount(int lottoSheetCount) {
        System.out.println(lottoSheetCount + "개를 구매했습니다.");
    }

    public static void printLottoSheets(List<LottoSheet> lottoSheets) {
        lottoSheets.forEach(lottoSheet -> printLottoNumbers(lottoSheet.getLottoNumbers()));
        System.out.println();
    }

    private static void printLottoNumbers(LottoNumbers lottoNumbers) {
        System.out.println(lottoNumbers.getLottoNumbers().toString());
    }

    public static void printLottoResults(LottoSheetResults lottoSheetResults) {
        System.out.println();
        System.out.println("당첨 통계");
        System.out.println("---------");

        Map<LottoNumberMatchCount, LottoSheetMatchCount> lottoSheetResultsValue = lottoSheetResults.getValue();


        for (Map.Entry<LottoNumberMatchCount, LottoCashPrize> lottoCashPrizeEntry : LOTTO_CASH_PRIZES.entrySet()) {
            LottoNumberMatchCount numberMatchCount = lottoCashPrizeEntry.getKey();
            LottoCashPrize cashPrize = lottoCashPrizeEntry.getValue();
            LottoSheetMatchCount sheetMatchCount = lottoSheetResultsValue
                    .getOrDefault(
                            numberMatchCount,
                            new LottoSheetMatchCount()
                    );

            System.out.println(
                    numberMatchCount.getValue() + "개 일치 (" + cashPrize.getValue() + "원)- " + sheetMatchCount.getValue() + "개");
        }
    }

    public static void printLottoProfits(int payment, LottoSheetResults lottoSheetResults) {
        System.out.println("총 수익률은 "+ Math.floor(lottoSheetResults.sumCashPrizes() / (double) payment * 100) / 100 + "입니다.");
    }
}
