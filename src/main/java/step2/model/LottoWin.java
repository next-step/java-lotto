package step2.model;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class LottoWin {

  private int firstWinnerCount;
  private int secondWinnerCount;
  private int thirdWinnerCount;
  private int fourthWinnerCount;

  private Lottos lottoWinners;
  private List<String> lottowinningNumbers;

  public LottoWin(String[] lottowinningNumbers) {
    firstWinnerCount = 0;
    secondWinnerCount = 0;
    thirdWinnerCount = 0;
    fourthWinnerCount = 0;

    this.lottoWinners = new Lottos();
    this.lottowinningNumbers = new ArrayList(Arrays.asList(lottowinningNumbers));
  }

  public void addWinningLotto(Lotto lotto) {

    int matchNumberCount = 0;

    for (String lottoNumStr : lottowinningNumbers) {
      matchNumberCount += isMatchNumber(lotto, lottoNumStr);
    }

    if (matchNumberCount > 0) {
      lottoWinners.addLotto(lotto);
      calculateWin(matchNumberCount);
    }
  }

  private int isMatchNumber(Lotto lotto, String lottoNumStr) {
    int matchNumberCount = 0;
    if (lotto.getLottoNumbers().contains(Integer.parseInt(lottoNumStr))) {
      matchNumberCount = 1;
    }
    return matchNumberCount;
  }

  public void calculateWin(int matchNumberCount) {
    if (matchNumberCount == WinnerMoney.FIRST_WINNER_MONEY.getMatchNumberCount()) {
      countUpFirstWinner();
    }

    if (matchNumberCount == WinnerMoney.SECOND_WINNER_MONEY.getMatchNumberCount()) {
      countUpSecondWinner();
    }

    if (matchNumberCount == WinnerMoney.THIRD_WINNER_MONEY.getMatchNumberCount()) {
      countUpThirdWinner();
    }

    if (matchNumberCount == WinnerMoney.FOURTH_WINNER_MONEY.getMatchNumberCount()) {
      countUpFourthWinner();
    }
  }

  public void countUpFirstWinner() {
    firstWinnerCount++;
  }

  public void countUpSecondWinner() {
    secondWinnerCount++;
  }

  public void countUpThirdWinner() {
    thirdWinnerCount++;
  }

  public void countUpFourthWinner() {
    fourthWinnerCount++;
  }

  public int getFirstWinnerCount() {
    return firstWinnerCount;
  }

  public int getSecondWinnerCount() {
    return secondWinnerCount;
  }

  public int getThirdWinnerCount() {
    return thirdWinnerCount;
  }

  public int getFourthWinnerCount() {
    return fourthWinnerCount;
  }

}
