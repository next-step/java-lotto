package lotto;

import static lotto.LottoGameConstant.NUMBERS_PER_TICKET;

import java.util.Collections;
import java.util.List;
import lotto.lottoexception.InvalidLottoFormatException;

public class LottoTicket {

  private final List<LottoNumber> lottoNumbers;

  private LottoTicket(List<LottoNumber> lottoNumbers) {
    this.lottoNumbers = lottoNumbers;
  }

  public static LottoTicket of(List<LottoNumber> lottoNumbers) {
    if (lottoNumbers == null || lottoNumbers.size() != NUMBERS_PER_TICKET) {
      throw new InvalidLottoFormatException();
    }

    Collections.sort(lottoNumbers);

    // 중복 체킹. sort 되어 있으므로 붙어 있는 번호가 동일하면 예외
    for (int i = 0; i < NUMBERS_PER_TICKET - 1; i++) {
      checkEquality(lottoNumbers.get(i), lottoNumbers.get(i + 1));
    }

    return new LottoTicket(lottoNumbers);
  }

  private static void checkEquality(LottoNumber number1, LottoNumber number2) {
    if (number1.equals(number2)) {
      throw new InvalidLottoFormatException();
    }
  }

  @Override
  public String toString() {
    return this.lottoNumbers.toString();
  }

  public int getNumHit(WinningNumber winningNumber) {
    int result = 0;
    for (LottoNumber lottoNumber : winningNumber) {
      result += this.lottoNumbers.contains(lottoNumber) ? 1 : 0;
    }
    return result;
  }
}
