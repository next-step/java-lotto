package lotto;

import java.util.List;

import static java.util.stream.Collectors.joining;

public class Lotto {
  public static final int PRICE = 1000;
  public static final int SIZE = 6;

  private final List<LottoNumber> numbers;

  public Lotto(List<LottoNumber> numbers) {
    validate(numbers);
    this.numbers = numbers;
  }

  private void validate(List<LottoNumber> numbers) {
    if (numbers.size() != SIZE) {
      throw new IllegalArgumentException("로또 번호는 6개여야 합니다.");
    }
    if (numbers.stream().distinct().count() != 6) {
      throw new IllegalArgumentException("로또 번호는 중복되지 않아야 합니다.");
    }
  }

  public int countMatchingNumbers(Lotto winningLotto) {
    return (int) numbers.stream()
            .filter(winningLotto::contains)
            .count();
  }

  private boolean contains(LottoNumber lottoNumber) {
    return numbers.contains(lottoNumber);
  }

  @Override
  public String toString() {
    return "[" + numbers.stream().map(LottoNumber::toString).collect(joining(", ")) + "]";
  }
}
