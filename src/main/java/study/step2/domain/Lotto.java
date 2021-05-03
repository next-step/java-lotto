package study.step2.domain;

import static study.step2.utils.MessageUtil.LOTTO_NUMBER_DUPLICATED;
import static study.step2.validator.Validator.NUMBER_OF_LOTTO_NUMBER;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

public class Lotto {

  private Set<LottoNumber> lottoNumbers = new HashSet<>();

  public Lotto() {
  }

  public Lotto(Set<LottoNumber> lottoNumbers) {
    this.lottoNumbers = lottoNumbers;
  }

  public Lotto(String inputText) {
    Arrays.stream(inputText.split(", "))
        .forEach(inputNumber -> lottoNumbers.add(LottoMachine.getLottoNumberMap().get(Integer.parseInt(inputNumber))));
  }

  public Set<LottoNumber> getLottoNumbers() {
    return lottoNumbers;
  }

  public void validatorPositiveNumbers() {
    lottoNumbers.forEach(LottoNumber::validatorPositiveNumber);
  }

  public void checkDuplication() {
    if (lottoNumbers.size() != NUMBER_OF_LOTTO_NUMBER) {
      throw new IllegalArgumentException(LOTTO_NUMBER_DUPLICATED);
    }
  }

  public int matchCount(Set<LottoNumber> winningLottoNumbers) {
    return (int) lottoNumbers.stream()
        .filter(winningLottoNumbers::contains)
        .count();
  }

  public boolean isMatchBonus(LottoNumber bonusNumber) {
    return lottoNumbers.contains(bonusNumber);
  }

  public void bonusValidation(LottoNumber bonusNumber) {
    if (lottoNumbers.contains(bonusNumber))
      throw new IllegalArgumentException("보너스 번호는 지난 담청 번호 6개와 같을 수 없습니다.");
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
    return Objects.equals(lottoNumbers, lotto.lottoNumbers);
  }

  @Override
  public int hashCode() {
    return Objects.hash(lottoNumbers);
  }

}
