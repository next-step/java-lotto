package lotto3.domain;


import java.util.List;
import java.util.stream.Collectors;

public class LottoNumbers {

  private static final int LOTTO_NUMBERS_SIZE = 6;
  private final List<LottoNumber> numbers;


  public LottoNumbers(List<Integer> numbers) {
    validateHasSixNumbers(numbers);
    validateHasNoDuplicate(numbers);
    this.numbers = convertToLottoNumbers(numbers);
  }

  private List<LottoNumber> convertToLottoNumbers(List<Integer> numbers) {

    return numbers.stream()
        .map(LottoNumber::new)
        .collect(Collectors.toList());
  }

  private void validateHasNoDuplicate(List<Integer> numbers) {
    if (numbers.stream().distinct().count() != LOTTO_NUMBERS_SIZE) {
      throw new IllegalArgumentException("로또 번호는 중복될 수 없습니다.");
    }
  }


  private void validateHasSixNumbers(List<Integer> numbers) {
    if (hasOverNumbers(numbers)) {
      throw new IllegalArgumentException("로또 번호는 6개만 가질 수 있습니다.");
    }
  }

  private static boolean hasOverNumbers(List<Integer> numbers) {
    return numbers.size() != LOTTO_NUMBERS_SIZE;
  }

  public List<LottoNumber> getLottoNumbers() {
    return numbers;
  }

  public int countMatch(LottoNumbers winningNumbers) {
    return (int) numbers.stream().
        filter(winningNumbers::contains)
        .count();
  }


  public boolean contains(LottoNumber bonusNumber) {
    return numbers.contains(bonusNumber);
  }

  public void validateHasDuplicateNumber(LottoNumber bonusNumber) {
    if (contains(bonusNumber)) {
      throw new IllegalArgumentException("보너스 볼은 당첨 번호와 중복될 수 없습니다.");
    }
  }
}
