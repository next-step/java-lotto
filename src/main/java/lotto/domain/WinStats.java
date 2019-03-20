package lotto.domain;

import java.util.List;

public class WinStats {

  private final Money threeWinMoney = new Money(5000);
  private final Money fourWinMoney = new Money(50000);
  private final Money fiveWinMoney = new Money(1500000);
  private final Money sixWinMoney = new Money(2000000000);

  private WinCount threeWinCount;
  private WinCount fourWinCount;
  private WinCount fiveWinCount;
  private WinCount sixWinCount;

  private List<Lotto> lottoList;
  private List<Number> winNumbers;

  public WinStats() {
    this.threeWinCount = new WinCount();
    this.fourWinCount = new WinCount();
    this.fiveWinCount = new WinCount();
    this.sixWinCount = new WinCount();
  }

  public WinStats(List<Lotto> lottoList, List<Number> winNumbers) {
    this();
    this.lottoList = lottoList;
    this.winNumbers = winNumbers;
  }

  public void total() {
    this.lottoList.forEach(lotto -> incrementWinCount(lotto.winMatch(this.winNumbers)));
  }

  private void incrementWinCount(int matchCount) {
    switch(matchCount) {
      case 3:
        threeWinCount.increment();
        break;
      case 4:
        fourWinCount.increment();
        break;
      case 5:
        fiveWinCount.increment();
        break;
      case 6:
        sixWinCount.increment();
        break;
    }
  }

  public Money getTotalWinMoney() {

    return getThreeWinMoney().count(threeWinCount)
        .sum(getFourWinMoney().count(fourWinCount))
        .sum(getFiveWinMoney().count(fiveWinCount))
        .sum(getSixWinMoney().count(sixWinCount));
  }

  public String yield(Money purchaseMoney) {
    return getTotalWinMoney().division(purchaseMoney);
  }

  public Money getThreeWinMoney() {
    return threeWinMoney;
  }

  public Money getFourWinMoney() {
    return fourWinMoney;
  }

  public Money getFiveWinMoney() {
    return fiveWinMoney;
  }

  public Money getSixWinMoney() {
    return sixWinMoney;
  }

  public WinCount getThreeWinCount() {
    return threeWinCount;
  }

  public WinCount getFourWinCount() {
    return fourWinCount;
  }

  public WinCount getFiveWinCount() {
    return fiveWinCount;
  }

  public WinCount getSixWinCount() {
    return sixWinCount;
  }
}
