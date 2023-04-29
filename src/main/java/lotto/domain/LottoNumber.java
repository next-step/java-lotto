package lotto.domain;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class LottoNumber implements Comparable<LottoNumber> {

  private static final Map<Integer, LottoNumber> LOTTO_NUMBERS = new HashMap<>();

  static {
    IntStream.rangeClosed(1, 45)
        .forEach(i -> LOTTO_NUMBERS.put(i, new LottoNumber(i)));
  }

  private final int number;

  private LottoNumber(int number) {
    this.number = number;
  }

  public static LottoNumber from(int number) {
    validNumberRange(number);
    return LOTTO_NUMBERS.get(number);
  }

  public static LottoNumber from(String number) {
    return LottoNumber.from(Integer.parseInt(number));
  }

  private static void validNumberRange(int number) {
    if (!LOTTO_NUMBERS.containsKey(number)) {
      throw new IllegalArgumentException("로또 번호는 1~45 사이의 숫자여야 합니다.");
    }
  }

  public int getNumber() {
    return number;
  }

  @Override
  public int compareTo(LottoNumber o) {
    return Integer.compare(number, o.number);
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;
    LottoNumber that = (LottoNumber) o;
    return number == that.number;
  }

  @Override
  public int hashCode() {
    return Objects.hash(number);
  }
}
