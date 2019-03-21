package lotto.domain;

public class WinCount {

  private Prizes prizes;
  private long count = 0;

  public WinCount(Prizes prizes, long count) {
    this.prizes = prizes;
    this.count = count;
  }

  public Prizes getPrizes() {
    return prizes;
  }

  public long getCount() {
    return count;
  }

  public Money getWinMoney() {
    return this.prizes.getMoney().count(count);
  }
}
