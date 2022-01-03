package lotto.domain;

public class LotteryTicket {

  public static final long PRICE = 1000;

  private LotteryNumbers lotteryNumbers;

  public LotteryTicket() {
    this.lotteryNumbers = new LotteryNumbers();
  }

  public LotteryNumbers lotteryNumbers() {
    return lotteryNumbers;
  }

  public void fixManual(LotteryNumbers lotteryNumbers) {
    this.lotteryNumbers = lotteryNumbers;
  }
}
