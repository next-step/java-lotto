package lotto.model;

import lotto.exception.ConflictLottoNumberException;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Lotto {

  static final int PRICE = 1_000;
  static final int COUNT_OF_NUMBERS = 6;

  private final List<Integer> generatedNumbers;

  public Lotto(List<Integer> generatedNumbers) {
    if (hasConflictNumber(generatedNumbers)) {
      throw new ConflictLottoNumberException();
    }
    this.generatedNumbers = generatedNumbers;
  }

  public int getCountOfMatchingNumbers(Lotto winningLotto) {
    return generatedNumbers.stream()
            .reduce(0, (countOfMatchingNumber, lottoNumber) -> winningLotto.contains(lottoNumber) ? countOfMatchingNumber + 1 : countOfMatchingNumber);
  }

  public boolean contains(int number) {
    return this.generatedNumbers.contains(number);
  }

  boolean hasConflictNumber(List<Integer> numbers) {
    final Set<Integer> temp = new HashSet<>();
    return !numbers.stream().allMatch(temp::add);
  }

  @Override
  public String toString() {
    return generatedNumbers.toString();
  }
}
