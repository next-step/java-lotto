package view;

import domain.Lotto;
import domain.LottoPrize;
import domain.LottoResult;
import domain.Lottos;

import java.util.Arrays;

public class LottoResultView {

  private static final String PRIZE_SHOW_FORMAT = "%d개 일치 (%d원)- %d개";

  private LottoResultView() { }

  public static void showBoughtLottoAmount(int boughtAmount) {
    System.out.println(boughtAmount + "개를 구매했습니다.");
  }

  public static void showLottos(Lottos lottos) {
    lottos.getLottos().forEach(lotto -> System.out.println(lotto.getLottoNumbers()));
  }

  public static void showLottoStatistics(LottoResult lottoResult) {
    System.out.println("당첨 통계");
    System.out.println("-----------");
    showEachPrizeResult(lottoResult);
  }

  private static void showEachPrizeResult(LottoResult lottoResult) {
    Arrays.stream(LottoPrize.values()).forEach(lottoPrize -> {
      int matchTotal = lottoResult.result(lottoPrize);
      String resultForEachPrize = String.format(PRIZE_SHOW_FORMAT, lottoPrize.matchCount, lottoPrize.prize, matchTotal);
      System.out.println(resultForEachPrize);
    });
  }

  public static void showLottoProfit(int lottoAmount, double totalLottoPrize) {
    int boughtLottoAmountPrice = lottoAmount * Lotto.PRICE_PER_LOTTO;
    double profit = totalLottoPrize / boughtLottoAmountPrice;
    double profitPercent = Math.round(profit * 10000) / 100;
    System.out.println("총 수익률은 " + profitPercent + "% 입니다.");
  }

}
