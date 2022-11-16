package nextstep.lotto.domain;

import java.util.Objects;
import java.util.Set;
import java.util.TreeSet;

public class Lotto {

  private final Set<LottoNumber> numbers;

  public Lotto(final Set<LottoNumber> numbers) {
    this.numbers = initNumbers(numbers);
  }

  private static Set<LottoNumber> initNumbers(final Set<LottoNumber> numbers) {
    if (numbers == null || numbers.size() != 6) {
      throw new IllegalArgumentException("로또 게임은 6개의 로또 넘버로 생성됩니다.");
    }
    return new TreeSet<>(numbers);
  }

  @Override
  public String toString() {
    return numbers.toString();
  }

  public int match(final Lotto other) {
    final Set<LottoNumber> retains = new TreeSet<>(this.numbers);
    retains.retainAll(other.numbers);
    return retains.size();
  }

  public boolean contains(final LottoNumber lottoNumber) {
    return this.numbers.contains(lottoNumber);
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

    return Objects.equals(numbers, lotto.numbers);
  }

  @Override
  public int hashCode() {
    return numbers != null ? numbers.hashCode() : 0;
  }
}
