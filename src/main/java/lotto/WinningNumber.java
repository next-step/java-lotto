package lotto;

import static lotto.LottoGameConstant.NUMBERS_PER_WINNING_NUMBER;

import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Spliterator;
import java.util.function.Consumer;
import lotto.lottoexception.InvalidLottoFormatException;

public class WinningNumber implements Iterable<LottoNumber> {

  private final List<LottoNumber> numbers;

  private WinningNumber(List<LottoNumber> lottoNumbers) {
    this.numbers = lottoNumbers;
  }

  public static WinningNumber of(List<LottoNumber> lottoNumbers) {

    if (lottoNumbers.size() != NUMBERS_PER_WINNING_NUMBER) {
      throw new InvalidLottoFormatException();
    }

    Collections.sort(lottoNumbers);

    for (int i = 0; i < NUMBERS_PER_WINNING_NUMBER - 1; i++) {
      checkEquality(lottoNumbers.get(i), lottoNumbers.get(i + 1));
    }

    return new WinningNumber(lottoNumbers);
  }

  private static void checkEquality(LottoNumber number1, LottoNumber number2) {
    if (number1.equals(number2)) {
      throw new InvalidLottoFormatException();
    }
  }

  @Override
  public Iterator<LottoNumber> iterator() {
    return this.numbers.iterator();
  }

  @Override
  public void forEach(Consumer<? super LottoNumber> action) {
    this.numbers.forEach(action);
  }

  @Override
  public Spliterator<LottoNumber> spliterator() {
    return this.numbers.spliterator();
  }
}
