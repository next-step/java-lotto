package lotto.exception;

import static lotto.domain.lotto.LottoNumbers.LOTTO_NUMBER_COUNT;

public class IllegalLottoNumberSizeException extends LottoException {

  public static final String LOTTO_NUMBER_CREATION_FAILURE = "로또는 " + LOTTO_NUMBER_COUNT + "개의 번호로 이루어져야 합니다.";

  public IllegalLottoNumberSizeException() {
    super(LOTTO_NUMBER_CREATION_FAILURE);
  }
}
