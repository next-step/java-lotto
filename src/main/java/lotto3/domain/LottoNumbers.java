package lotto3.domain;

import java.util.List;

public class LottoNumbers {

  private static final int LOTTO_NUMBERS_SIZE = 6;
  private static final int LOTTO_NUMBER_START = 1;
  private static final int LOTTO_NUMBER_END = 45;
  private final List<Integer> numbers;

  public LottoNumbers(List<Integer> numbers) {
    this.numbers = numbers;
    validateHasSixNumbers();
    validateIsBetweenOneAndFortyFive();
    validateHasNoDuplicate();
  }

  private void validateHasNoDuplicate() {
    if (numbers.stream().distinct().count() != LOTTO_NUMBERS_SIZE) {
      throw new IllegalArgumentException("로또 번호는 중복될 수 없습니다.");
    }
  }

  private void validateIsBetweenOneAndFortyFive() {
    this.numbers.stream()
        .filter(number -> number < LOTTO_NUMBER_START || number > LOTTO_NUMBER_END)
        .findAny()
        .ifPresent(number -> {
          throw new IllegalArgumentException("로또 번호는 1~45 사이의 숫자여야 합니다.");
        });
  }

  private void validateHasSixNumbers() {
    if (numbers.size() != 6) {
      throw new IllegalArgumentException("로또 번호는 6개만 가질 수 있습니다.");
    }
  }

  public List<Integer> getNumbers() {
    return numbers;
  }

  public int countMatch(WinningNumbers winningNumbers) {
    return (int) numbers.stream().
        filter(winningNumbers::contains).
        count();
  }


  public boolean contains(BonusNumber bonusNumber) {
    return bonusNumber.contains(numbers);
  }
}
