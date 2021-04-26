package study.step2.domain;

import static study.step2.utils.MessageUtil.LOTTO_NUMBER_DUPLICATED;
import static study.step2.utils.MessageUtil.VALIDATOR_NUMBER_MESSAGE;
import static study.step2.validator.Validator.NUMBER_OF_LOTTO_NUMBER;

import java.util.Arrays;
import java.util.Objects;
import java.util.Set;
import java.util.TreeSet;
import java.util.stream.Collectors;

public class LottoNumber {

  private Set<Integer> lottoNumbers;

  public LottoNumber(Set<Integer> lottoNumbers) {
    this.lottoNumbers = lottoNumbers;
  }

  public LottoNumber(String[] lottoNumbers) {
    this.lottoNumbers = Arrays.stream(lottoNumbers)
        .map(Integer::parseInt)
        .collect(Collectors.toCollection(TreeSet::new));
  }

  public Set<Integer> getLottoNumbers() {
    return lottoNumbers;
  }

  public boolean isContains(int lottoNumber) {
    return lottoNumbers.contains(lottoNumber);
  }

  public void validatorPositiveNumbers() {
    boolean result = lottoNumbers.stream().anyMatch(number -> number < 0);

    if (result) {
      throw new IllegalArgumentException(VALIDATOR_NUMBER_MESSAGE);
    }
  }

  public void checkDuplication() {
    if (lottoNumbers.size() != NUMBER_OF_LOTTO_NUMBER) {
      throw new IllegalArgumentException(LOTTO_NUMBER_DUPLICATED);
    }
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    LottoNumber that = (LottoNumber) o;
    return Objects.equals(lottoNumbers, that.lottoNumbers);
  }

  @Override
  public int hashCode() {
    return Objects.hash(lottoNumbers);
  }

  @Override
  public String toString() {
    return lottoNumbers.toString();
  }

}
