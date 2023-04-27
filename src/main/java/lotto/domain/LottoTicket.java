package lotto.domain;

public class LottoTicket {
  public static final int TICKET_PRICE = 1_000;
  private final LottoNumbers lottoNumbers;

  public LottoTicket(LottoNumbers lottoNumbers) {
    this.lottoNumbers = lottoNumbers;
  }

  public MatchNumbersCount matchCount(LottoNumbers winningNumbers) {
    return MatchNumbersCount.get(lottoNumbers.matchCount(winningNumbers));
  }

  public LottoNumbers getLottoNumbers() {
    return lottoNumbers;
  }
}
