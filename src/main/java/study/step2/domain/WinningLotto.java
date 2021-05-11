package study.step2.domain;

import static study.step2.Exception.CustomException.BONUS_NUMBER_INVALID_MESSAGE_EXCEPTION;
import static study.step2.Exception.CustomException.LOTTO_NUMBER_DUPLICATED_EXCEPTION;
import static study.step2.validator.Validator.NUMBER_OF_LOTTO_NUMBER;

import java.util.Arrays;
import java.util.Set;
import java.util.stream.Collectors;

public class WinningLotto {

  private final Set<LottoNumber> lottoNumbers;

  public WinningLotto(String inputText) {
    this.lottoNumbers =  Arrays.stream(inputText.split(","))
        .map(String::trim)
        .map(LottoNumber::valueOf)
        .collect(Collectors.toSet());
  }

  public void validatorPositiveNumbers() {
    lottoNumbers.forEach(LottoNumber::validatorPositiveNumber);
  }

  public void checkDuplication() {
    if (lottoNumbers.size() != NUMBER_OF_LOTTO_NUMBER) {
      throw LOTTO_NUMBER_DUPLICATED_EXCEPTION;
    }
  }

  public Set<LottoNumber> getLottoNumbers() {
    return lottoNumbers;
  }

  public void bonusValidation(LottoNumber bonusNumber) {
    if (lottoNumbers.contains(bonusNumber))
      throw BONUS_NUMBER_INVALID_MESSAGE_EXCEPTION;
  }
}
