package lotto;

import static lotto.LottoGameConstant.NUMBERS_PER_TICKET;

import java.util.Collections;
import java.util.List;
import lotto.lottoexception.InvalidLottoFormatException;

public class LottoTicket {

  private final List<LottoNumber> lottoNumbers;
  private final LottoNumberBundle bundle;

  private LottoTicket(List<LottoNumber> numbers, LottoNumberBundle bundle) {
    this.lottoNumbers = numbers;
    this.bundle = bundle;
  }

  public static LottoTicket of(LottoNumberBundle bundle) {
    return new LottoTicket(null, bundle);
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

    return new LottoTicket(lottoNumbers, null);
  }

  private static void checkEquality(LottoNumber number1, LottoNumber number2) {
    if (number1.equals(number2)) {
      throw new InvalidLottoFormatException();
    }
  }

  public int guessNumHit(WinningNumber winningNumber) {
    if (this.lottoNumbers != null) {
      int result = 0;
      for (LottoNumber lottoNumber : winningNumber) {
        result += this.lottoNumbers.contains(lottoNumber) ? 1 : 0;
      }
      return result;
    }

    if (this.bundle != null) {
      int result = 0;
      for (LottoNumber lottoNumber : winningNumber) {
        result += this.bundle.contains(lottoNumber) ? 1 : 0;
      }
      return result;
    }

    return -1;
  }

  public Rank decideRewardWithBonusBall(WinningNumber winningNumber, LottoNumber bonusNumber) {
    int numHit = this.guessNumHit(winningNumber);
    boolean matchedWithBonusBall = this.lottoNumbers.contains(bonusNumber);
    return Rank.getRewardWithBonusBall(numHit, matchedWithBonusBall);
  }

  @Override
  public String toString() {
    if (this.lottoNumbers != null) {
      return this.lottoNumbers.toString();
    }

    return this.bundle.toString();
  }
}
