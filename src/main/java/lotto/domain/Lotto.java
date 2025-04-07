package lotto.domain;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class Lotto {
  private static final int LOTTO_SIZE = 6;
  private final List<LottoNumber> numbers;

  public Lotto(List<Integer> numbers) {
    validateSize(numbers);
    validateDuplicate(numbers);
    this.numbers = numbers.stream().map(LottoNumber::new).collect(Collectors.toList());
  }

  public Lotto(List<LottoNumber> numbers, boolean isLottoNumber) {
    validateSize(numbers);
    validateDuplicate(numbers);
    this.numbers = numbers;
  }

  private void validateSize(List<?> numbers) {
    if (numbers.size() != LOTTO_SIZE) {
      throw new IllegalArgumentException("로또 번호는 6개여야 합니다.");
    }
  }

  private void validateDuplicate(List<?> numbers) {
    if (numbers.stream().distinct().count() != LOTTO_SIZE) {
      throw new IllegalArgumentException("로또 번호에 중복이 있습니다.");
    }
  }

  public List<Integer> getNumbers() {
    return numbers.stream().map(LottoNumber::getNumber).collect(Collectors.toUnmodifiableList());
  }

  public List<LottoNumber> getLottoNumbers() {
    return Collections.unmodifiableList(numbers);
  }

  public int countMatchingNumbers(Lotto winningLotto) {
    return (int) numbers.stream().filter(number -> winningLotto.contains(number)).count();
  }

  public boolean contains(LottoNumber lottoNumber) {
    return numbers.contains(lottoNumber);
  }

  public boolean containsNumber(int number) {
    return numbers.stream().anyMatch(lottoNumber -> lottoNumber.getNumber() == number);
  }

  public boolean matchBonus(LottoNumber bonusNumber) {
    return numbers.contains(bonusNumber);
  }
}
