package lotto;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class LottoTicketNumber implements Comparable<LottoTicketNumber> {

  private static final int MIN_BOUND = 1;
  private static final int MAX_BOUND = 45;
  private final Integer number;

  public LottoTicketNumber(Integer number) {
    validateNumber(number);
    this.number = number;
  }

  public static int getMaxBound() {
    return MAX_BOUND;
  }

  public static int getMinBound() {
    return MIN_BOUND;
  }

  public static List<LottoTicketNumber> generateAllPossibleNumbers() {
    return IntStream.rangeClosed(MIN_BOUND, MAX_BOUND)
        .mapToObj(LottoTicketNumber::new)
        .collect(Collectors.toList());
  }

  private void validateNumber(Integer number) {
    if (number < MIN_BOUND || number > MAX_BOUND) {
      throw new IllegalArgumentException("로또 번호는 1~45 사이여야 합니다.");
    }
  }

  @Override
  public int compareTo(LottoTicketNumber other) {
    return this.number.compareTo(other.number);
  }

  @Override
  public String toString() {
    return number.toString();
  }

  @Override
  public boolean equals(Object o) {
    if (o == null || getClass() != o.getClass()) {
      return false;
    }

    LottoTicketNumber that = (LottoTicketNumber) o;
    return number.equals(that.number);
  }

  @Override
  public int hashCode() {
    return number.hashCode();
  }
}
