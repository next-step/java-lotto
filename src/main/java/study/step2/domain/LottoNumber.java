package study.step2.domain;


import static study.step2.Exception.CustomException.LOTTO_NUMBER_INVALID_RANGE_EXCEPTION;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class LottoNumber {

  private static final int LOTTO_MIN_NUMBER = 1;
  private static final int LOTTO_MAX_NUMBER = 45;

  private static final Map<Integer, LottoNumber> lottoNumberMap = new HashMap<>();

  private final int lottoNumber;

  static {
    for (int i = LOTTO_MIN_NUMBER; i <= LOTTO_MAX_NUMBER; i++) {
      lottoNumberMap.put(i, new LottoNumber(i));
    }
  }

  public LottoNumber(int lottoNumber) {
    if (lottoNumber < LOTTO_MIN_NUMBER || lottoNumber > LOTTO_MAX_NUMBER) {
      throw LOTTO_NUMBER_INVALID_RANGE_EXCEPTION;
    }
    this.lottoNumber = lottoNumber;
  }

  public static LottoNumber valueOf(String s) {
    return valueOf(Integer.parseInt(s));
  }

  public static LottoNumber valueOf(int inputNumber) {
    LottoNumber lottoNumber = lottoNumberMap.get(inputNumber);

    validateInvalidRangeNumber(lottoNumber);

    return lottoNumber;
  }

  public int getLottoNumber() {
    return lottoNumber;
  }

  public static void validateInvalidRangeNumber(LottoNumber lottoNumber) {
    if (lottoNumber == null) {
      throw LOTTO_NUMBER_INVALID_RANGE_EXCEPTION;
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

}
