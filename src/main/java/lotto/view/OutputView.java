package lotto.view;

import static java.util.stream.Collectors.joining;

import java.util.Arrays;
import java.util.List;
import lotto.LottoNumber;
import lotto.LottoNumbers;
import lotto.Lottos;
import lotto.Quantity;
import lotto.Rank;
import lotto.Rewards;
import lotto.Statistics;

public class OutputView {

  public static final String NUMBERS_DELIMITER = ", ";
  public static final String PURCHASE_COUNT_FORMAT = "수동으로 %d장, 자동으로 %d 개를 구매했습니다.";
  public static final String LOTTO_NUMBERS_FORMAT = "[ %s ]";
  public static final String LOTTO_REWARDS_FORMAT = "%d개 일치 (%d원) - %d개";
  public static final String LOTTO_SECOND_REWARDS_FORMAT = "%d개 일치, 보너스 볼 일치 (%d원) - %d개";
  public static final String INCOME_RATE_FORMAT = "총 수익률은 %f 입니다.(기준이 1이기 때문에 결과적으로 %s라는 의미임)";
  public static final String PROFIT = "이익";
  public static final String LOSS = "손해";
  public static final int BREAK_EVEN_POINT = 1;

  public static void printPurchasedLottoQuantity(Quantity manualQuantity, Quantity autoQuantity) {
    System.out.printf(PURCHASE_COUNT_FORMAT, manualQuantity.getValue(),autoQuantity.getValue());
    printBlankLine();
  }

  private static void printBlankLine() {
    System.out.println();
  }

  public static void printPurchasedLottosNumber(Lottos lottos) {
    printBlankLine();
    List<LottoNumbers> purchasedLottoNumbers = lottos.getPurchasedLottoNumbers();
    purchasedLottoNumbers.stream().forEach(lottoNumbers -> printLottoNumbers(lottoNumbers));
  }

  private static void printLottoNumbers(LottoNumbers lottoNumbers) {
    String lottoNumber = lottoNumbers.getValues()
        .stream()
        .map(LottoNumber::getValue)
        .map(number -> number.toString())
        .collect(joining(NUMBERS_DELIMITER));
    System.out.printf(LOTTO_NUMBERS_FORMAT, lottoNumber);
    printBlankLine();
  }

  public static void printStatistics(Statistics statistics) {
    printBlankLine();
    printRewards(statistics.getRewards());
    printYield(statistics.getYield());
  }

  private static void printRewards(Rewards rewards) {
    Arrays.stream(Rank.values()).forEach(rank -> printReward(rank, rewards.getRankCount(rank)));
  }

  private static void printReward(Rank rank, int rankCount) {
    printBlankLine();
    if(rank.isSecond(rank)) {
      System.out.printf(LOTTO_SECOND_REWARDS_FORMAT, rank.getBoundaryCount(), rank.getPrize(), rankCount);
      return;
    }
    System.out.printf(LOTTO_REWARDS_FORMAT, rank.getBoundaryCount(), rank.getPrize(), rankCount);
  }

  private static void printYield(double yield) {
    String word = yield > BREAK_EVEN_POINT ? PROFIT : LOSS;
    System.out.printf(INCOME_RATE_FORMAT, yield, word);
  }

}
