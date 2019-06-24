package lotto.domain;

import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Objects;

public class LottoTicket {

  static final int LOTTO_NUMBER_SIZE = 6;
  private final List<Integer> numbers;

  public LottoTicket(List<Integer> numbers) {
    validateNumberSize(numbers);
    validateDuplicate(numbers);
    validateNumbersRange(numbers);
    this.numbers = numbers;
    Collections.sort(numbers);
  }

  private void validateNumbersRange(List<Integer> numbers) {
    boolean match = numbers.stream().anyMatch(number -> number < 1 || number > 45);
    if (match) {
      throw new IllegalArgumentException("1 ~ 45 사이의 숫자만 입력할 수 있습니다.");
    }
  }

  private void validateDuplicate(List<Integer> numbers) {
    if (new HashSet<>(numbers).size() != LOTTO_NUMBER_SIZE) {
      throw new IllegalArgumentException("중복된 숫자가 입력될 수 없습니다.");
    }
  }

  private void validateNumberSize(List<Integer> numbers) {
    if (numbers.size() != LOTTO_NUMBER_SIZE) {
      throw new IllegalArgumentException("로또 번호는 6자리여야 합니다.");
    }
  }

  public Rank winNumberSize(List<Integer> winNumber) {
    return Rank.getInstance(
        winNumber.stream()
            .filter(numbers::contains)
            .count());
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;
    LottoTicket that = (LottoTicket) o;
    return Objects.equals(numbers, that.numbers);
  }

  @Override
  public int hashCode() {
    return Objects.hash(numbers);
  }

  @Override
  public String toString() {
    return numbers.toString();
  }
}
