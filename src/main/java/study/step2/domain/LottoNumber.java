package study.step2.domain;


import static study.step2.utils.MessageUtil.LOTTO_NUMBER_INVALID_RANGE;
import static study.step2.utils.MessageUtil.VALIDATOR_NUMBER_MESSAGE;

import java.util.Objects;

public class LottoNumber implements Comparable<LottoNumber>{

  private static final int LOTTO_MIN_NUMBER = 1;
  private static final int LOTTO_MAX_NUMBER = 45;

  private final int lottoNumber;

  public LottoNumber(int lottoNumber) {
    if (lottoNumber < LOTTO_MIN_NUMBER || lottoNumber > LOTTO_MAX_NUMBER) {
      throw new IllegalArgumentException(LOTTO_NUMBER_INVALID_RANGE);
    }
    this.lottoNumber = lottoNumber;
  }

  public int getLottoNumber() {
    return lottoNumber;
  }

  public void validatorPositiveNumber() {
    if (lottoNumber < 0) {
      throw new IllegalArgumentException(VALIDATOR_NUMBER_MESSAGE);
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
    return lottoNumber == that.lottoNumber;
  }

  @Override
  public int hashCode() {
    return Objects.hash(lottoNumber);
  }

  @Override
  public String toString() {
    return String.valueOf(lottoNumber);
  }

  @Override
  public int compareTo(LottoNumber o) {
    return this.lottoNumber - o.lottoNumber;
  }

}
