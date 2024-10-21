package lotto.view;

import lotto.domain.LottoCashPrize;
import lotto.domain.LottoNumber;
import lotto.domain.LottoNumbers;
import lotto.domain.LottoNumbersResults;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

import static lotto.domain.LottoCashPrize.getValuablePrizes;

public class ResultView {

    public static void printLottoNumbersCount(int sheetCount, int manualSheetCount) {
        System.out.println("수동으로 " + manualSheetCount + "장, 자동으로 " + (sheetCount - manualSheetCount) + "개를 구매했습니다.");
    }

    public static void printLottoNumbersList(List<LottoNumbers> lottoNumbersList) {
        lottoNumbersList.forEach(lottoNumbers -> System.out.println(lottoNumbers.getLottoNumbers()
                .stream()
                .map(LottoNumber::getLottoNumber)
                .collect(Collectors.toList())));
        System.out.println();
    }

    public static void printLottoResults(LottoNumbersResults lottoNumbersResults) {
        printLottoResultsHeader();
        getValuablePrizes().stream()
                .sorted(Comparator.comparing(LottoCashPrize::getMatchedCount)
                        .thenComparing(LottoCashPrize::hasBonus))
                .forEach(prize -> printLottoResultsRow(prize, lottoNumbersResults));
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

    public static void printLottoResultsRow(LottoCashPrize lottoCashPrize, LottoNumbersResults lottoNumbersResults) {
        int count = lottoNumbersResults.getValue()
                .getOrDefault(lottoCashPrize, 0);

        if (lottoCashPrize.hasBonus()) {
            System.out.println(
                    lottoCashPrize.getMatchedCount() + "개 일치, 보너스볼 일치 (" + lottoCashPrize.getPrize() + "원)- " + count + "개");
            return;
        }

        System.out.println(
                lottoCashPrize.getMatchedCount() + "개 일치 (" + lottoCashPrize.getPrize() + "원)- " + count + "개");
    }
}
