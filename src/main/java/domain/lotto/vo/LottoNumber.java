package domain.lotto.vo;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

public class LottoNumber {
  private Integer number;
  private static final int MIN_NUMBER = 1;
  private static final int MAX_NUMBER = 45;

  private static final List<LottoNumber> LOTTO_NUMBERS = new ArrayList<>();

  static {
    IntStream.range(MIN_NUMBER, MAX_NUMBER + 1)
        .mapToObj(LottoNumber::new).forEach(LOTTO_NUMBERS::add);
  }

  public static LottoNumber of(int number) {
    validateNumber(number);
    return LOTTO_NUMBERS.get(number - 1);
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
