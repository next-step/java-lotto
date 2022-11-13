package nextstep.lotto.domain;

import static nextstep.lotto.domain.LottoNumber.lottoNumber;

import java.util.Arrays;
import java.util.Objects;
import java.util.Set;
import java.util.TreeSet;
import java.util.stream.Collectors;

public class Lotto {

  private final Set<LottoNumber> numbers;

  public Lotto(final Set<LottoNumber> numbers) {
    this.numbers = initNumbers(numbers);
  }

  public Lotto(int number1, int number2, int number3, int number4, int number5, int number6) {
    this(
      Set.of(
        lottoNumber(number1),
        lottoNumber(number2),
        lottoNumber(number3),
        lottoNumber(number4),
        lottoNumber(number5),
        lottoNumber(number6)
      )
    );
  }

  public Lotto(final String winningNumbers) {
    if(winningNumbers == null || winningNumbers.isBlank()) {
      throw new IllegalArgumentException("로또 번호는 공백일 수 없습니다.");
    }

    final String[] split = winningNumbers.split(",");
    final Set<LottoNumber> numbers = Arrays.stream(split)
      .map(String::trim)
      .map(LottoNumber::lottoNumber)
      .collect(Collectors.toSet());

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
