package lotto;

import static lotto.LottoGameConstant.NUMBERS_PER_WINNING_NUMBER;

import java.util.Collections;
import java.util.List;

public class WinningNumber {

  private final List<LottoNumber> numbers;

  private WinningNumber(List<LottoNumber> lottoNumbers) {
    this.numbers = lottoNumbers;
  }

  public static WinningNumber of(List<LottoNumber> lottoNumbers) {

    if (lottoNumbers.size() != NUMBERS_PER_WINNING_NUMBER) {
      throw new IllegalArgumentException();
    }

    Collections.sort(lottoNumbers);

    for (int i = 0; i < NUMBERS_PER_WINNING_NUMBER - 1; i++) {
      checkEquality(lottoNumbers.get(i), lottoNumbers.get(i + 1));
    }

    return new WinningNumber(lottoNumbers);
  }

  private static void checkEquality(LottoNumber number1, LottoNumber number2) {
    if (number1.equals(number2)) {
      throw new IllegalArgumentException();
    }
  }
}
