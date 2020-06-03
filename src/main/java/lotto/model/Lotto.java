package lotto.model;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Objects;

public class Lotto {

  public final static Money PRICE = new Money(1000);
  public final static int LOTTO_SIZE = 6;

  private final List<Integer> numbers;

  public Lotto(List<Integer> numbers) {
    checkLottoNumberSize(numbers);
    checkLottoNumberRange(numbers);
    checkLottoNumberDuplicated(numbers);

    numbers.sort(Integer::compareTo);

    this.numbers = new ArrayList<>(numbers);
  }

  private void checkLottoNumberSize(List<Integer> numbers) {
    if (numbers.size() != LOTTO_SIZE) {
      throw new IllegalArgumentException("로또 숫자는 6개가 입력되어야 합니다. " + numbers);
    }
  }

  private void checkLottoNumberRange(List<Integer> numberList) {
    if (!LottoNumberPool.INSTANCE.getNumbers().containsAll(numberList)) {
      throw new IllegalArgumentException("로또 숫자는 1~45 사이로 입력되어야 합니다.");
    }
  }

  private void checkLottoNumberDuplicated(List<Integer> numbers) {
    if (new HashSet<>(numbers).size() != LOTTO_SIZE) {
      throw new IllegalArgumentException("로또 숫자는 중복되면 안됩니다.");
    }
  }

  public int numberOfMatchesTo(Lotto lotto) {
    int matchCnt = 0;

    for (Integer number : lotto.numbers) {
      matchCnt += this.has(number) ? 1 : 0;
    }

    return matchCnt;
  }

  public boolean has(Integer number) {
    return this.numbers.contains(number);
  }

  @Override
  public String toString() {
    return numbers.toString();
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    Lotto lotto = (Lotto) o;
    return numbers.equals(lotto.numbers);
  }

  @Override
  public int hashCode() {
    return Objects.hash(numbers);
  }
}
