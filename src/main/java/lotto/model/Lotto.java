package lotto.model;

import java.util.List;

public class Lotto {

  static final int PRICE = 1_000;

  private final List<Integer> generatedNumbers;

  public Lotto(List<Integer> generatedNumbers) {
    this.generatedNumbers = generatedNumbers;
  }

  public int getCountOfMatchingNumbers(List<Integer> winningNumbers) {
    return generatedNumbers.stream()
            .reduce(0, (countOfMatchingNumber, lottoNumber) -> winningNumbers.contains(lottoNumber) ? countOfMatchingNumber + 1 : countOfMatchingNumber);
  }

  @Override
  public String toString() {
    return generatedNumbers.toString();
  }
}
