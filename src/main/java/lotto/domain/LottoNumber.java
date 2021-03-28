package lotto.domain;

import java.util.HashMap;
import java.util.Map;
import lotto.constant.Constant;

public class LottoNumber implements Comparable<LottoNumber> {

  private static Map<Integer, LottoNumber> lottoNumbers = new HashMap<>();
  private final int number;

  static {
    for (int i = Constant.MIN_NUM; i <= Constant.MAX_NUM; i++) {
      lottoNumbers.put(i, new LottoNumber(i));
    }
  }

  private LottoNumber(int number) {
    this.number = number;
  }

  public static LottoNumber of(int number) {
    LottoNumber lottoNumber = lottoNumbers.get(number);
    if (lottoNumber == null) {
      throw new IllegalArgumentException("로또 번호는 1에서 45 사이 값만 가합니다.");
    }
    return lottoNumber;
  }

  public int getLottoNumber() {
    return number;
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
    return number;
  }

  @Override
  public int compareTo(LottoNumber o) {
    return 0;
  }
}
