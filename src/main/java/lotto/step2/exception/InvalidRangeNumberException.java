package lotto.step2.exception;

import lotto.step2.domain.Lotto;

public class InvalidRangeNumberException extends RuntimeException {

  private static final String ERROR_MESSAGE = String.format(
                                                "유효한 범위(%d ~ %d)의 로또 번호가 아닙니다.",
                                                Lotto.MIN_VALUE,
                                                Lotto.MAX_VALUE
                                              );

  public InvalidRangeNumberException() {
    super(ERROR_MESSAGE);
  }
}
