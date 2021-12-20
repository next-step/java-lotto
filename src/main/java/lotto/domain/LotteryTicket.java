package lotto.domain;

import java.util.Set;

public class LotteryTicket {

  public static final int PRICE = 1000;

  public final LotteryNumbers lotteryNumbers;

  public LotteryTicket() {
    this.lotteryNumbers = new LotteryNumbers();
  }

  public Set<LotteryNumber> getLotteryNumbers() {
    return lotteryNumbers.getLotteryNumbers();
  }
}
