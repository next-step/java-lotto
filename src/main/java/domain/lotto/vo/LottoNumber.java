package domain.lotto.vo;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.IntStream;

public class LottoNumber {
  private final Integer number;
  private static final int MIN_NUMBER = 1;
  private static final int MAX_NUMBER = 45;

  private static final Map<Integer, LottoNumber> LOTTO_NUMBERS = new HashMap<>();

  static {
    IntStream.range(MIN_NUMBER, MAX_NUMBER + 1)
            .forEach((number) -> LOTTO_NUMBERS.put(number, new LottoNumber(number)));
  }

  public static LottoNumber of(int number) {
    validateNumber(number);
    return LOTTO_NUMBERS.get(number);
  }

  private LottoNumber(Integer number) {
    validateNumber(number);
    this.number = number;
  }

  public Integer getNumber() {
    return number;
  }

  private static void validateNumber(int number) {
    if(number < MIN_NUMBER || number > MAX_NUMBER) {
      throw new IllegalArgumentException("로또 번호는 1부터 45까지 가능합니다.");
    }
  }

  @Override
  public boolean equals(Object obj) {
    if (this == obj) {
      return true;
    }
    if (obj == null || getClass() != obj.getClass()) {
      return false;
    }
    LottoNumber that = (LottoNumber) obj;
    return number.equals(that.number);
  }

  @Override
  public int hashCode() {
    return number.hashCode();
  }
}
