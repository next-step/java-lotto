package lotto.domain;

import java.util.Objects;
import lotto.exception.InvalidLottoNumberRangeException;

public class LottoNumber implements Comparable<LottoNumber> {

  public static final int MIN = 1;
  public static final int MAX = 45;

  private final int number;
  private static final LottoNumber[] lottoNumberCache = new LottoNumber[MAX];

  public LottoNumber(String number){
    this(Integer.parseInt(number));
  }

  public LottoNumber(int number) {
    validateNumber(number);
    this.number = number;
  }

  public static LottoNumber valueOf(int number) {
    validateNumber(number);
    if (lottoNumberCache[number - 1] == null){
      lottoNumberCache[number - 1] = new LottoNumber(number);
    }
    return lottoNumberCache[number - 1];
  }

  public int number() {
    return number;
  }

  private static void validateNumber(int number) {
    if (number < MIN || number > MAX) {
      throw new InvalidLottoNumberRangeException();
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
    return number == that.number;
  }

  @Override
  public int hashCode() {
    return Objects.hash(number);
  }

  @Override
  public int compareTo(LottoNumber other) {
    return Integer.compare(number, other.number);
  }
}
