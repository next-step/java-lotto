package lotto.domain;

import java.util.HashSet;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class LottoNumber implements Comparable<LottoNumber> {

  public static final List<Integer> POSSIBLE_NUMBER_RANGE = IntStream.rangeClosed(1, 45)
                                                                     .boxed()
                                                                     .collect(Collectors.toList());

  private final int number;

  public LottoNumber(String number) {
    this(Integer.parseInt(number));
  }

  public LottoNumber(int number) {
    validNumberRange(number);
    this.number = number;
  }

  private static void validNumberRange(int number) {
    if (!new HashSet<>(POSSIBLE_NUMBER_RANGE).contains(number)) {
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
