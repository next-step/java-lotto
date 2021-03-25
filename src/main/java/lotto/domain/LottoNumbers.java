package lotto.domain;

import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.stream.Collectors;
import lotto.constant.Constant;

public class LottoNumbers {

  private final List<LottoNumber> numbers;
  private LottoNumberStore store = new LottoNumberStore();

  public LottoNumbers() {
    this.numbers = generateLottoNumbers(store.createLottoNumbers());
  }

  public LottoNumbers(List<LottoNumber> numbers) {
    this.numbers = generateLottoNumbers(numbers);
  }

  public List<LottoNumber> generateLottoNumbers(List<LottoNumber> numbers) {
    validateSize(numbers);
    validateDuplication(numbers);
    return numbers;
  }

  public List<LottoNumber> numbers() {
    return Collections.unmodifiableList(numbers);
  }

  public void validateSize(List<LottoNumber> numbers) {
    if (numbers.size() != Constant.LOTTO_NUMBER_SIZE) {
      throw new IllegalArgumentException("로또 번호는 6개여야 합니다.");
    }
  }

  public void validateDuplication(List<LottoNumber> lottoNumbers) {
    HashSet<LottoNumber> numbers = new HashSet<>(lottoNumbers);
    if (numbers.size() != Constant.LOTTO_NUMBER_SIZE) {
      throw new IllegalArgumentException("로또 번호는 중복이 불가능합니다.");
    }
  }

  @Override
  public String toString() {
    return numbers.stream()
        .map(LottoNumber::getLottoNumber)
        .collect(Collectors.toList())
        .toString();
  }
}
