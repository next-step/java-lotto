package lotto.domain;

import java.util.Objects;

public class LottoNumber implements Comparable<LottoNumber> {

  public static final int MIN = 1;
  public static final int MAX = 45;

  private final int number;
  private static final LottoNumber[] lottoNumberCache = new LottoNumber[45];

  public LottoNumber(int number) {
    checkNumber(number);
    this.number = number;
  }

  public static LottoNumber valueOf(int number) {
    checkNumber(number);
    if (lottoNumberCache[number - 1] != null){
      return lottoNumberCache[number - 1];
    }
    lottoNumberCache[number - 1] = new LottoNumber(number);
    return lottoNumberCache[number - 1];
  }

  public int number() {
    return number;
  }

  private static void checkNumber(int number) {
    if (number < MIN || number > MAX) {
      throw new IllegalArgumentException("생성 가능한 로또 번호는 " + MIN + "부터 " + MAX + "까지입니다.");
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
    return Integer.compare(this.number, other.number);
  }
}
