package lotto.domain;

import java.util.Arrays;

public enum PRIZES {
  FIRST(6, 2_000_000_000),
  SECOND(5, 30_000_000),
  THIRD(5, 1_500_000),
  FOURTH(4, 50_000),
  FIFTH(3, 5_000),
  MISS(0, 0);

  private int winningsNumber;
  private int winningMoney;

  private PRIZES(int winningsNumber, int winningMoney) {
    this.winningsNumber = winningsNumber;
    this.winningMoney = winningMoney;
  }

  public int getWinningsNumber() {
    return winningsNumber;
  }
  public int getWinningMoney() {
    return winningMoney;
  }


  public static int getWinningMoneyByWinningNumber(int winningsNumber) {
    return Arrays.stream(values())
        .filter(prize -> prize.winningsNumber == winningsNumber)
        .findFirst()
        .map(PRIZES::getWinningMoney)
        .orElse(0);
  }
}
