package view;

import lotto.LottoRank;
import lotto.LottoResult;
import lotto.number.LottoNumbers;

import java.util.Arrays;
import java.util.List;

public class ResultView {
    private static final String AVERAGE_TEXT_FORMAT = "%d개 일치 (%d원)- %d개";
    private static final String AVERAGE_SECOND_TEXT_FORMAT = "%d개 일치, 보너스 볼 일치(%d원)- %d개";
    private static final String PURCHASE_RESULT_TEXT_FORMAT = "%d개를 구매했습니다.";
    private static final String TOTAL_INCOME_RATE_TEXT_FORMAT = "총 수익률은 %.2f입니다.";

    private ResultView() {/* prevent creating instance. */}

    public static void printLottoCounts(int lottoCounts) {
        String purchaseResultText = String.format(PURCHASE_RESULT_TEXT_FORMAT, lottoCounts);
        System.out.println(purchaseResultText);
    }

    public static void printLottoNumbersBundle(List<LottoNumbers> lottoNumbersBundle) {
        lottoNumbersBundle.forEach(System.out::println);
    }

    public static void printLottoResults(LottoResult lottoResult) {
        System.out.println("당첨 통계");
        System.out.println("--------");
        printAverageTexts(lottoResult);
        printIncomeRate(lottoResult);
    }

    private static void printAverageTexts(LottoResult lottoResult) {
        Arrays.stream(LottoRank.values())
              .filter(rank -> rank != LottoRank.MISS)
              .map(rank -> createLottoRankString(lottoResult, rank))
              .forEach(System.out::println);
    }

    private static String createLottoRankString(LottoResult lottoResult, LottoRank lottoRank) {
        int totalCountOfMatch = lottoResult.countOfLottoRankMatched(lottoRank);
        int lottoWinningMoney = lottoRank.getWinningMoney();
        int matchOfCount = lottoRank.getCountOfMatch();

        if (lottoRank == LottoRank.SECOND) {
            return String.format(AVERAGE_SECOND_TEXT_FORMAT, matchOfCount, lottoWinningMoney, totalCountOfMatch);
        }

        return String.format(AVERAGE_TEXT_FORMAT, matchOfCount, lottoWinningMoney, totalCountOfMatch);
    }

    private static void printIncomeRate(LottoResult lottoResult) {
        double incomeRate = lottoResult.computeIncomeRate();
        System.out.printf(TOTAL_INCOME_RATE_TEXT_FORMAT, incomeRate);
    }
}
