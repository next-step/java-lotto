package lotto;

import static lotto.LottoGameConstant.MAXIMUM_LOTTO_NUMBER;
import static lotto.LottoGameConstant.MINIMUM_LOTTO_NUMBER;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import lotto.lottoexception.IllegalLottoNumberRangeException;

public class LottoNumber implements Comparable<LottoNumber> {

  private static final List<LottoNumber> numbers
      = IntStream.rangeClosed(MINIMUM_LOTTO_NUMBER, MAXIMUM_LOTTO_NUMBER)
      .mapToObj(LottoNumber::new)
      .collect(Collectors.toList());

  private final int number;

  private LottoNumber(int number) {
    this.number = number;
  }

  public static LottoNumber of(int number) {
    return get(number);
  }

  public static LottoNumber get(int number) {
    validateNumber(number);
    return numbers.get(number - 1);
  }

  private static void validateNumber(int number) {
    if (!(MINIMUM_LOTTO_NUMBER <= number && number <= MAXIMUM_LOTTO_NUMBER)) {
      throw new IllegalLottoNumberRangeException();
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
    return this.number == that.number;
  }

  @Override
  public int hashCode() {
    return Objects.hash(this.number);
  }

  @Override
  public String toString() {
    return String.valueOf(this.number);
  }

  @Override
  public int compareTo(LottoNumber that) {
    return Integer.compare(this.number, that.number);
  }
}
