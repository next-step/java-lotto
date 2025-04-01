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

  public int getWinningMoney() {
    return winningMoney;
  }

  public static PRIZES valueOf(int winningsNumber, boolean matchBonus) {
    if (winningsNumber == 5) {
      return matchBonus ? SECOND : THIRD;
    }

    return Arrays.stream(values())
        .filter(prizes -> prizes.winningsNumber == winningsNumber)
        .findFirst()
        .orElse(MISS);
  }

  public long calculateWinning(int totalWinningCount) {
    return (long) winningMoney * totalWinningCount;
  }

  public void updateWinningCount(LottoResults lottoResults) {
    LottoResult existingResult = lottoResults.findLottoResult(winningsNumber);
    if (existingResult != null) {
      existingResult.increaseTotalWinningCount();
    } else {
      lottoResults.addLottoResult(winningsNumber);
    }
  }
}
