package lotto.domain;

import java.util.Objects;

public class LottoTicket {
  public static final int TICKET_PRICE = 1_000;
  private final LottoNumbers lottoNumbers;

  public LottoTicket(LottoNumbers lottoNumbers) {
    this.lottoNumbers = lottoNumbers;
  }

  public MatchNumbersCount matchCount(LottoNumbers winningNumbers, LottoNumber bonusNumber) {
    return lottoNumbers.matchCount(winningNumbers, bonusNumber);
  }

  public LottoNumbers getLottoNumbers() {
    return lottoNumbers;
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
}
