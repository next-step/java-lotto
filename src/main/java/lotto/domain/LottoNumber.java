package lotto.domain;

import java.util.Collections;
import java.util.HashSet;
import java.util.List;

public class LottoNumber {

  private static final int MIN = 1;
  private static final int MAX = 45;
  static final int LOTTO_NUMBER_SIZE = 6;

  private final List<Integer> numbers;

  public LottoNumber(List<Integer> numbers) {
    validateNumberSize(numbers);
    validateDuplicate(numbers);
    validateNumbersRange(numbers);
    this.numbers = numbers;
    Collections.sort(this.numbers);
  }

  public Rank winNumberSize(List<Integer> winNumber) {
    return Rank.getInstance(
        winNumber.stream()
            .filter(numbers::contains)
            .count());
  }

  private void validateNumbersRange(List<Integer> numbers) {
    boolean match = numbers.stream().anyMatch(number -> number < MIN || number > MAX);
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

  @Override
  public String toString() {
    return numbers.toString();
  }
}
