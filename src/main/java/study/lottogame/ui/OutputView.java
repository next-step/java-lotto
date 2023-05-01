package study.lottogame.ui;

import java.util.Map;
import study.lottogame.domain.GameResult;
import study.lottogame.domain.Lotteries;
import study.lottogame.domain.Lottery;
import study.lottogame.domain.Money;
import study.lottogame.domain.Rank;

public class OutputView {

  public static void printLotteries(Lotteries lotteries) {
    System.out.println(lotteries.getLotteries().size() + "개를 구매했습니다.");
    for (Lottery lottery : lotteries.getLotteries()) {
      System.out.println(lottery.getLottoNumbers());
    }
  }

  public static void printGameResult(Money inputMoney, GameResult gameResult) {
    System.out.println("\n당첨 통계\n" + "---------");
    printPrizeStatics(gameResult.getPrizeStaticsMap());
    printRateOfReturn(inputMoney, gameResult.getPrizeMoney());
  }

  private static void printPrizeStatics(Map<Rank, Integer> prizeStaticsMap) {
    for (Rank rank : Rank.values()) {
      if (!rank.equals(Rank.MISS)) {
        Integer lotteryCount = prizeStaticsMap.getOrDefault(rank, 0);
        System.out.printf("%d개 일치 (%d원)- %d개 \n", rank.getCountOfMatch(), rank.getWinningMoney(),
            lotteryCount);
      }
    }
  }

  private static void printRateOfReturn(Money prizeMoney, Money inputMoney) {
    double rateOfReturn = prizeMoney.getMoneyRate(inputMoney);
    System.out.printf("총 수익률은 %.2f 입니다. (기준이 1이기 때문에 결과적으로 손해라는 의미임) \n", rateOfReturn);
  }
}
