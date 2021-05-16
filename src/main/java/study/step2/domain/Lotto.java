package study.step2.domain;

import static study.step2.Exception.CustomException.LOTTO_NUMBER_DUPLICATED_EXCEPTION;
import static study.step2.validator.Validator.NUMBER_OF_LOTTO_NUMBER;

import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Lotto {

  private Set<LottoNumber> lottoNumbers;

  public Lotto() {
  }

  public Lotto(Set<LottoNumber> lottoNumbers) {
    this.lottoNumbers = lottoNumbers;
  }

  public Lotto(String inputText) {
    lottoNumbers = Arrays.stream(inputText.split(","))
        .map(String::trim)
        .map(LottoNumber::valueOf)
        .collect(Collectors.toSet());
  }

  public Set<LottoNumber> getLottoNumbers() {
    return lottoNumbers;
  }

  public void validatorPositiveNumbers() {
    lottoNumbers.forEach(LottoNumber::validatorPositiveNumber);
  }

  public void checkDuplication() {
    if (lottoNumbers.size() != NUMBER_OF_LOTTO_NUMBER) {
      throw LOTTO_NUMBER_DUPLICATED_EXCEPTION;
    }
  }

  public int matchCount(Set<LottoNumber> winningLottoNumbers) {
    return (int) lottoNumbers.stream()
        .filter(winningLottoNumbers::contains)
        .count();
  }

  public static Lottos makeLottos(int lottoCount) {
    List<Lotto> lottoList = IntStream.range(0, lottoCount)
        .mapToObj(i -> LottoNumber.pick())
        .map(Lotto::new)
        .collect(Collectors.toList());

    return new Lottos(lottoList);
  }

  public boolean isMatchBonus(LottoNumber bonusNumber) {
    return lottoNumbers.contains(bonusNumber);
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
