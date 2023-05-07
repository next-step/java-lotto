package lotto3.domain;


import java.util.List;
import java.util.stream.Collectors;

public class LottoNumbers {

  private static final int LOTTO_NUMBERS_SIZE = 6;
  private final List<LottoNumber> numbers;


  public LottoNumbers(List<Integer> numbers) {
    this.numbers = convertToLottoNumbers(numbers);
    validateHasSixNumbers();
    validateHasNoDuplicate();
  }

  private List<LottoNumber> convertToLottoNumbers(List<Integer> numbers) {
    return numbers.stream()
        .map(LottoNumber::new)
        .collect(Collectors.toList());
  }

  private void validateHasNoDuplicate() {
    if (numbers.stream().distinct().count() != LOTTO_NUMBERS_SIZE) {
      throw new IllegalArgumentException("로또 번호는 중복될 수 없습니다.");
    }
  }


  private void validateHasSixNumbers() {
    if (numbers.size() != LOTTO_NUMBERS_SIZE) {
      throw new IllegalArgumentException("로또 번호는 6개만 가질 수 있습니다.");
    }
  }

  public List<LottoNumber> getLottoNumbers() {
    return numbers;
  }

  public int countMatch(WinningNumbers winningNumbers) {
    return (int) numbers.stream().
        filter(winningNumbers::contains).
        count();
  }


  public boolean contains(LottoNumber bonusNumber) {
    return numbers.stream()
        .anyMatch(number -> number.equals(bonusNumber));
  }
}
