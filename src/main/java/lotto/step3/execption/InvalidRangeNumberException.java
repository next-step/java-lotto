package lotto.step3.execption;

import lotto.step3.domain.LottoNumber;

public class InvalidRangeNumberException extends RuntimeException {

  private static final String ERROR_MESSAGE = String.format(
                                                "유효한 범위(%d ~ %d)의 로또 번호가 아닙니다.",
                                                LottoNumber.MIN_VALUE,
                                                LottoNumber.MAX_VALUE
                                              );

  public InvalidRangeNumberException() {
    super(ERROR_MESSAGE);
  }
}
