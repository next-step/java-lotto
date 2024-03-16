package model;

import java.util.List;

public class Lotto {

  private static final int MAX_LOTTO_NUMBERS = 6;

  private final List<Integer> numbers;

  public Lotto(final List<Integer> numbers) {
    validateLottoNumbers(numbers);
    this.numbers = numbers;
  }

  public int findMatchNumberCount(WinningNumbers winningNumbers) {
    return (int) this.numbers.stream()
        .filter(number -> winningNumbers.getNumbers().contains(number))
        .mapToInt(it -> it)
        .count();
  }

  private void validateLottoNumbers(final List<Integer> numbers) {
    if (numbers.size() != MAX_LOTTO_NUMBERS) {
      throw new IllegalArgumentException("로또 번호의 개수는 6개여야 합니다.");
    }
  }
}
