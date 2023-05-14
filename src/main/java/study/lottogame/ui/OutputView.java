package study.lottogame.ui;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import study.lottogame.domain.GameResult;
import study.lottogame.domain.Lotteries;
import study.lottogame.domain.Lottery;
import study.lottogame.domain.LottoNumber;
import study.lottogame.domain.Money;
import study.lottogame.domain.Rank;

public class OutputView {

  private OutputView() {
  }

  public static void printLotteries(int manualLotteryCount, Lotteries lotteries) {
    System.out.printf("수동으로 %d장, 자동으로 %d개를 구매했습니다.\n", manualLotteryCount,
        lotteries.getLotteries().size() - manualLotteryCount);
    for (Lottery lottery : lotteries.getLotteries()) {
      List<LottoNumber> lottoNumbers = new ArrayList<>(lottery.getLottoNumbers());
      Collections.sort(lottoNumbers);
      System.out.println(lottoNumbers);
    }
  }

  public static void printGameResult(Money inputMoney, GameResult gameResult) {
    System.out.println("\n당첨 통계\n" + "---------");
    printPrizeStatics(gameResult.getPrizeStaticsMap());
    printRateOfReturn(inputMoney, gameResult.getPrizeMoney());
  }

  private static void printPrizeStatics(Map<Rank, Integer> prizeStaticsMap) {
    Arrays.stream(Rank.values())
        .filter(rank -> !rank.equals(Rank.MISS))
        .forEach(rank -> printPrizeResult(prizeStaticsMap, rank));
  }

  private static void printPrizeResult(Map<Rank, Integer> prizeStaticsMap, Rank rank) {
    Integer lotteryCount = prizeStaticsMap.getOrDefault(rank, 0);
    System.out.printf("%d개 일치 (%d원)- %d개 \n", rank.getCountOfMatch(), rank.getWinningMoney(),
        lotteryCount);
  }

  private static void printRateOfReturn(Money inputMoney, Money prizeMoney) {
    double rateOfReturn = prizeMoney.getMoneyRate(inputMoney);
    System.out.printf("총 수익률은 %.2f 입니다. (기준이 1이기 때문에 결과적으로 손해라는 의미임) \n", rateOfReturn);
  }
}
