package lotto.domain;

import java.util.List;

public class WinningLotteryNumbers {

  private static final String DUPLICATED_EXCEPTION = "The bonus number is duplicated.";
  private static final int ADD_BONUS_COUNT = 1;

  private final LotteryNumbers lotteryNumbers;
  private final LotteryNumber bonusNumber;

  public WinningLotteryNumbers(List<Integer> lotteryNumbers, int bonusNumber) {
    this(new LotteryNumbers(lotteryNumbers), new LotteryNumber(bonusNumber));
  }

  public WinningLotteryNumbers(LotteryNumbers lotteryNumbers, LotteryNumber bonusNumber) {
    validateOrThrow(lotteryNumbers, bonusNumber);
    this.lotteryNumbers = lotteryNumbers;
    this.bonusNumber = bonusNumber;
  }

  public WinningLottery rank(LotteryNumbers bought) {
    if (lotteryNumbers.size() != bought.size()) {
      return WinningLottery.NONE;
    }

    boolean matchBonus = bought.contains(bonusNumber);
    int matchCount = matchCount(bought, matchBonus);

    return WinningLottery.of(matchCount, matchBonus);
  }

  private int matchCount(LotteryNumbers bought, boolean matchBonus) {
    int matchCount = lotteryNumbers.matchCount(bought);

    if (matchBonus) {
      return matchCount + ADD_BONUS_COUNT;
    }

    return matchCount;
  }

  private void validateOrThrow(LotteryNumbers lotteryNumbers, LotteryNumber bonusNumber) {
    if (lotteryNumbers.contains(bonusNumber)) {
      throw new IllegalArgumentException(DUPLICATED_EXCEPTION);
    }
  }
}
