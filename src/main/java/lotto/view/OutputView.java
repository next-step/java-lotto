package lotto.view;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import lotto.Lotto;
import lotto.LottoNumber;
import lotto.LottoNumbers;
import lotto.Lottos;
import lotto.Quantity;
import lotto.Reward;
import lotto.Rewards;
import lotto.Statistics;

public class OutputView {

  public static final String NUMBERS_DELIMITER = ", ";
  public static final String LAST_WEEK_LOTTO_NUMBERS_DELIMITER = ",";
  public static final String PURCHASE_COUNT_FORMAT = "%d 개를 구매했습니다.";
  public static final String LOTTO_NUMBERS_FORMAT = "[ %s ]";
  public static final String LOTTO_REWARDS_FORMAT = "%d개 일치 (%d원) - %d개";
  public static final String INCOME_RATE_FORMAT = "총 수익률은 %f 입니다.(기준이 1이기 때문에 결과적으로 %s라는 의미임)";
  public static final String PROFIT = "이익";
  public static final String LOSS = "손해";

  public static void printPurchasedLottoQuantity(Quantity quantity) {
    System.out.printf(PURCHASE_COUNT_FORMAT, quantity.getValue());
    printBlankLine();
  }

  private static void printBlankLine() {
    System.out.println();
  }

  public static void printPurchasedLottosNumber(Lottos lottos) {
    printBlankLine();
    List<Lotto> purchasedLotto = lottos.getPurchasedLotto();
    purchasedLotto.stream().forEach(lotto -> printLotto(lotto));
  }

  private static void printLotto(Lotto lotto) {
    LottoNumbers numbers = lotto.getNumbers();
    String result = numbers.getValues().stream()
        .map(LottoNumber::getValue)
        .map(number -> number.toString())
        .collect(Collectors.joining(NUMBERS_DELIMITER));
    System.out.printf(LOTTO_NUMBERS_FORMAT, result);
    printBlankLine();
  }

  public static void printStatistics(Lottos lottos, String lastWeekWinLottoNumber) {
    printBlankLine();
    Lotto lastWeekWinLotto = getLastWeekWinLotto(lastWeekWinLottoNumber);
    Statistics statistics = new Statistics(lottos, lastWeekWinLotto);
    Rewards rewards = statistics.getRewards();
    printRewards(rewards.getReward());
    printYield(statistics.getYield());

  }

  private static void printYield(double yield) {
    String word = yield > 1 ? PROFIT : LOSS;
    System.out.printf(INCOME_RATE_FORMAT,yield,word);
  }

  private static void printRewards(List<Reward> rewards) {
    rewards.stream().forEach(reward -> printReward(reward));
  }

  private static void printReward(Reward reward) {
    System.out.printf(LOTTO_REWARDS_FORMAT, reward.getBoundaryCount(), reward.getPrize(),
        reward.getMatchedCount());
    printBlankLine();
  }

  private static Lotto getLastWeekWinLotto(String lastWeekWinLottoNumber) {
    List<Integer> numbers = Arrays
        .stream(lastWeekWinLottoNumber.split(LAST_WEEK_LOTTO_NUMBERS_DELIMITER))
        .map(number -> number.trim())
        .map(Integer::parseInt)
        .collect(Collectors.toList());
    return new Lotto(numbers);
  }
}
