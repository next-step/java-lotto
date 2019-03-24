package lotto.domain;

import java.util.HashMap;
import java.util.Map;

public class LottoNumber {

  private static final Map<Integer, LottoNumber> reusableLottoNumber = new HashMap<>();

  public final static int MINIMUM = 1;
  public final static int MAXIMUM = 45;

  private final int number;

  private LottoNumber(int number) {

    this.number = number;
    if (isInvalidRange(number < MINIMUM, number > MAXIMUM)) {
      throw new IllegalArgumentException();
    }
  }

  public static LottoNumber getInstance(int number) {

    if(!reusableLottoNumber.containsKey(number)) {

      LottoNumber lottoNumber= new LottoNumber(number);
      reusableLottoNumber.put(number, lottoNumber);
    }

    return reusableLottoNumber.get(number);
  }

  private boolean isInvalidRange(boolean b, boolean b2) {
    return b || b2;
  }

  @Override
  public String toString() {
    return number + "";
  }
}
