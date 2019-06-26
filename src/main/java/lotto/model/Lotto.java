package lotto.model;

import java.util.List;

public class Lotto {

  static final int PRICE = 1_000;

  private final List<Integer> generatedNumbers;

  public Lotto(List<Integer> generatedNumbers) {
    this.generatedNumbers = generatedNumbers;
  }

  public int getCountOfMatchingNumbers(Lotto winningLotto) {
    return generatedNumbers.stream()
            .reduce(0, (countOfMatchingNumber, lottoNumber) -> winningLotto.contains(lottoNumber) ? countOfMatchingNumber + 1 : countOfMatchingNumber);
  }

  public List<Integer> getGeneratedNumbers() {
    return generatedNumbers;
  }

  public boolean contains(int number) {
    return this.generatedNumbers.contains(number);
  }

  public Prize matches(WinningLotto winningLotto) {
    int countOfMatchingNumbers = getCountOfMatchingNumbers(winningLotto.getLotto());
    boolean hasBonusNumber = this.contains(winningLotto.getBonusNumber());

    return Prize.valueOf(countOfMatchingNumbers, hasBonusNumber);
  }

  @Override
  public String toString() {
    return generatedNumbers.toString();
  }
}
