package lotto;

import java.util.Random;

public class LottoTicketNumber {

  private static final int MIN_BOUND = 1;
  private static final int MAX_BOUND = 45;
  private final Integer number;

  public LottoTicketNumber() {
    this(new Random().nextInt(MAX_BOUND) + 1);
  }

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

  private void validateNumber(Integer number) {
    if (number < MIN_BOUND || number > MAX_BOUND) {
      throw new IllegalArgumentException("로또 번호는 1~45 사이여야 합니다.");
    }
  }

  @Override
  public String toString() {
    return number.toString();
  }
}
