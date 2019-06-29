package lotto.model;

import lotto.exception.DuplicatetLottoNumberException;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Lotto {

  static final int PRICE = 1_000;
  static final int COUNT_OF_NUMBERS = 6;

  private final List<LottoNumber> generatedNumbers;

  public Lotto(List<LottoNumber> generatedNumbers) {
    if (hasConflictNumber(generatedNumbers)) {
      throw new DuplicatetLottoNumberException();
    }
    this.generatedNumbers = generatedNumbers;
  }

  public int getCountOfMatchingNumbers(Lotto winningLotto) {
    return (int) generatedNumbers.stream()
            .filter(winningLotto::contains)
            .count();
  }

  public boolean contains(LottoNumber number) {
    return this.generatedNumbers.contains(number);
  }

  boolean hasConflictNumber(List<LottoNumber> numbers) {
    final Set<LottoNumber> temp = new HashSet<>();
    return !numbers.stream().allMatch(temp::add);
  }

  @Override
  public String toString() {
    return generatedNumbers.toString();
  }
}
