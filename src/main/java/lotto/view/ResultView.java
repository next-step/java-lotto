package lotto.view;

import lotto.domain.LottoGame;
import lotto.domain.Money;
import lotto.domain.Ranking;
import lotto.domain.Statistics;

public class ResultView {

  private static final String BUY_COMMENT = "개를 구매했습니다.";
  private static final String STATISTICS = "당첨통계";
  private static final String UNAVAILABLE_GAME = "로또 게임을 진행할 수 없습니다.";

  public void printBuyingLottoGame(LottoGame lottoGame) {
    System.out.println(lottoGame.getLottoBallNumbersString());
  }

  public void printLottoBuySize(LottoGame lottoGames) {
    System.out.println(lottoGames.size() + BUY_COMMENT);
  }

  public void printUnavailableGame() {
    System.out.println(UNAVAILABLE_GAME);
  }

  public void printLottoResult(Money investMoney, Statistics statistics) {
    System.out.println(STATISTICS);
    System.out.println("------------");
    System.out.println("3개 일치 (5000원) - " +
        statistics.countGame(new StatisticsDto(Ranking.FOURTH, new Money(5000))));
    System.out.println("4개 일치 (50000원) - " +
        statistics.countGame(new StatisticsDto(Ranking.THIRD, new Money(50000))));
    System.out.println("5개 일치 (1500000원) - " +
        statistics.countGame(new StatisticsDto(Ranking.SECOND, new Money(1500000))));
    System.out.println("6개 일치 (2000000000원) - " +
        statistics.countGame(new StatisticsDto(Ranking.FIRST, new Money(2000000000))));
    System.out.println("총 수익률은 " + calculateEarningRate(investMoney, statistics) + " 입니다.");
  }

  private double calculateEarningRate(Money investMoney, Statistics statistics) {
    return statistics.getEarningRate(investMoney);
  }
}
