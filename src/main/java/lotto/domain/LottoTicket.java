package lotto.domain;

import java.util.Objects;

public class LottoTicket {

  static final int LOTTO_NUMBER_SIZE = 6;
  private final LottoNumbers lottoNumbers;

  public LottoTicket(LottoNumbers lottoNumbers) {
    this.lottoNumbers = lottoNumbers;
  }

  public Rank winNumberSize(WinNumber winNumber) {
    return winNumber.match(lottoNumbers);
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;
    LottoTicket that = (LottoTicket) o;
    return Objects.equals(lottoNumbers, that.lottoNumbers);
  }

  @Override
  public int hashCode() {
    return Objects.hash(lottoNumbers);
  }

  @Override
  public String toString() {
    return lottoNumbers.toString();
  }
}
