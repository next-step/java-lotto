package lotto.domain;

import java.util.List;
import java.util.stream.Collectors;

public class Lotto {

  private static final int LOTTO_SIZE = 6;
  private final List<LottoNo> numbers;

  public Lotto(List<Integer> numbers) {
    validateSize(numbers);
    validateDuplicate(numbers);
    this.numbers = numbers.stream()
        .map(LottoNo::from)
        .sorted()
        .collect(Collectors.toList());
  }

  private void validateSize(List<Integer> numbers) {
    if (numbers == null) {
      throw new IllegalArgumentException("로또 번호가 null입니다.");
    }
    if (numbers.size() != LOTTO_SIZE) {
      throw new IllegalArgumentException(String.format("로또 번호는 %d개여야 합니다. 하지만 %d개입니다.", LOTTO_SIZE, numbers.size()));
    }
  }

  private void validateDuplicate(List<Integer> numbers) {
    if (numbers.size() != numbers.stream().distinct().count()) {
      throw new IllegalArgumentException("로또 번호에 중복된 숫자가 있습니다.");
    }
  }

  public int countMatchingNumbers(Lotto other) {
    if (other == null) {
      throw new IllegalArgumentException("비교할 로또가 null입니다.");
    }
    return (int) numbers.stream()
        .filter(other.numbers::contains)
        .count();
  }

  public boolean hasBonusBall(int bonusBall) {
    return numbers.contains(LottoNo.from(bonusBall));
  }

  public List<Integer> getNumbers() {
    return numbers.stream()
        .map(LottoNo::getNumber)
        .collect(Collectors.toList());
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
    return numbers.hashCode();
  }
}
