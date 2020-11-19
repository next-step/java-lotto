package lotto;

import static lotto.LottoGameConstant.MAXIMUM_LOTTO_NUMBER;
import static lotto.LottoGameConstant.MINIMUM_LOTTO_NUMBER;
import static lotto.LottoGameConstant.NUMBERS_PER_WINNING_NUMBER;

import java.util.ArrayList;
import java.util.List;
import lotto.lottoexception.IllegalLottoNumberRange;

public class WinningNumber {

  private final List<LottoNumber> numbers;

  private WinningNumber(List<LottoNumber> lottoNumbers) {
    this.numbers = lottoNumbers;
  }

  public static WinningNumber of(String input) {
    String[] tokenizedInputs = input.split(", ");
    List<LottoNumber> numbers = new ArrayList<>();

    if (tokenizedInputs.length != NUMBERS_PER_WINNING_NUMBER) {
      throw new IllegalArgumentException();
    }

    for (String tokenizedInput : tokenizedInputs) {
      int castedInput = Integer.parseInt(tokenizedInput);
      validateValue(castedInput);
      numbers.add(NumberPool.getNumber(castedInput));
    }

    for (int i = 0; i < NUMBERS_PER_WINNING_NUMBER - 1; i++) {
      checkEquality(numbers.get(i), numbers.get(i + 1));
    }

    return new WinningNumber(numbers);
  }

  private static void validateValue(int number) {
    if (!(MINIMUM_LOTTO_NUMBER <= number && number <= MAXIMUM_LOTTO_NUMBER)) {
      throw new IllegalLottoNumberRange();
    }
  }

  private static void checkEquality(LottoNumber number1, LottoNumber number2) {
    if (number1.equals(number2)) {
      throw new IllegalArgumentException();
    }
  }
}
