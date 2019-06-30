package view;

import lotto.Lotto;
import lotto.LottoRank;
import lotto.LottoResults;

import java.util.Arrays;
import java.util.List;

public class ResultView {
    private static final String AVERAGE_TEXT_FORMAT = "%d개 일치 (%d원)- %d개";
    private static final String PURCHASE_RESULT_TEXT_FORMAT = "%d개를 구매했습니다.";
    private static final String TOTAL_INCOME_RATE_TEXT_FORMAT = "총 수익률은 %.2f입니다.";

    private ResultView() {/* prevent creating instance. */}

    public static void printLottoCounts(int lottoCounts) {
        String purchaseResultText = String.format(PURCHASE_RESULT_TEXT_FORMAT, lottoCounts);
        System.out.println(purchaseResultText);
    }

    public static void printLottos(List<Lotto> lottos) {
        lottos.stream()
                .map(Lotto::getLottoNumbers)
                .forEach(System.out::println);
    }

    public static void printLottoResults(LottoResults lottoResults) {
        System.out.println("당첨 통계");
        System.out.println("--------");
        printAverageTexts(lottoResults);
        printIncomeRate(lottoResults);
    }

    private static void printAverageTexts(LottoResults lottoResults) {
        Arrays.stream(LottoRank.values())
              .filter(rank -> rank != LottoRank.MISS)
              .map(rank -> {
                  int totalCountOfMatch = lottoResults.totalCountOfMatch(rank);
                  int lottoWinningMoney = rank.getWinningMoney();
                  int matchOfCount = rank.getCountOfMatch();
                  return String.format(AVERAGE_TEXT_FORMAT, matchOfCount, lottoWinningMoney, totalCountOfMatch);
              })
              .forEach(System.out::println);
    }

    private static void printIncomeRate(LottoResults lottoResults) {
        double incomeRate = lottoResults.getIncomeRate();
        System.out.printf(TOTAL_INCOME_RATE_TEXT_FORMAT, incomeRate);
    }
}
