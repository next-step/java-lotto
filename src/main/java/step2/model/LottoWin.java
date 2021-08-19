package step2.model;

public class LottoWin {

  private int firstWinnerCount;
  private int secondWinnerCount;
  private int thirdWinnerCount;
  private int fourthWinnerCount;

  public LottoWin() {
    firstWinnerCount = 0;
    secondWinnerCount = 0;
    thirdWinnerCount = 0;
    fourthWinnerCount = 0;
  }

  public LottoWin(int firstWinnerCount, int secondWinnerCount, int thirdWinnerCount,
      int fourthWinnerCount) {
    this.firstWinnerCount = firstWinnerCount;
    this.secondWinnerCount = secondWinnerCount;
    this.thirdWinnerCount = thirdWinnerCount;
    this.fourthWinnerCount = fourthWinnerCount;
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
