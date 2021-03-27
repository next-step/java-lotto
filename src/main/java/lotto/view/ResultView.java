package lotto.view;

import lotto.domain.LottoGame;
import lotto.domain.LottoGames;
import lotto.domain.Money;
import lotto.domain.Statistics;

public class ResultView {

  private static final String BUY_COMMENT = "개를 구매했습니다.";
  private static final String STATISTICS = "당첨통계";
  private static final int THREE = 3;
  private static final int FOUR = 4;
  private static final int FIVE = 5;
  private static final int SIX = 6;

  public void printBuyingLottoGame(LottoGames lottoGames) {
    printLottoBuySize(lottoGames);
    printLottoDrawResult(lottoGames);
  }

  private void printLottoBuySize(LottoGames lottoGames) {
    System.out.println(lottoGames.size() + BUY_COMMENT);
  }

  private void printLottoDrawResult(LottoGames lottoGames) {
    StringBuilder builder;
    for (LottoGame lottoGame : lottoGames.getLottoGames()) {
      builder = new StringBuilder();
      builder.append("[");
      builder.append(lottoGame.getLottoBallNumbersString());
      builder.append("]");
      System.out.println(builder.toString());
    }
  }

  public void printLottoResult(Money investMoney, Statistics statistics) {
    System.out.println(STATISTICS);
    System.out.println("------------");
    System.out.println("3개 일치 (5000원) - " +
        statistics.calculateStatistics(new StatisticsDto(THREE,new Money(5000))));
    System.out.println("4개 일치 (50000원) - " +
        statistics.calculateStatistics(new StatisticsDto(FOUR,new Money(50000))));
    System.out.println("5개 일치 (1500000원) - " +
        statistics.calculateStatistics(new StatisticsDto(FIVE,new Money(1500000))));
    System.out.println("6개 일치 (2000000000원) - " +
        statistics.calculateStatistics(new StatisticsDto(SIX,new Money(2000000000))));
    System.out.println("총 수익률은 " + calculateEarningRate(investMoney,statistics)  + " 입니다.");
  }

  private double calculateEarningRate(Money investMoney, Statistics statistics) {
    return statistics.getEarningRate(investMoney);
  }
}
