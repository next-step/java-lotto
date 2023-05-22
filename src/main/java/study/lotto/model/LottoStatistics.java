package study.lotto.model;

import java.util.List;

public class LottoStatistics {
  int three;
  int four;
  int five;
  int six;
  double rate;

  public LottoStatistics(Lotto lotto, LottoNumber winning) {
    List<LottoNumber> numbers = lotto.getNumbers();
    for(LottoNumber number : numbers) {
      int sameCount = calculateSameNumber(number, winning);
      this.updateState(sameCount);
    }

    rate = this.calculateRate(lotto.getCount() * 1000);
  }

  private double calculateRate(double amount) {
    double sum = 0;
    sum += 5000 * this.three;
    sum += 50000 * this.four;
    sum += 1500000 * this.five;
    sum += 2000000000 * this.six;
    return sum / amount;
  }

  private void updateState(int sameCount) {
    switch (sameCount) {
      case 3:
        three++;
        break;
      case 4:
        four++;
        break;
      case 5:
        five++;
        break;
      case 6:
        six++;
        break;
    }
  }

  private int calculateSameNumber(LottoNumber number, LottoNumber winning) {
    return number.sameCount(winning);
  }

  public int getThree() {
    return three;
  }

  public int getFour() {
    return four;
  }

  public int getFive() {
    return five;
  }

  public int getSix() {
    return six;
  }

  public double getRate() {
    return rate;
  }
}
