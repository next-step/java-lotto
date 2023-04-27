package lotto.domain;

import java.util.List;

public class LottoTickets {
  private final List<LottoTicket> lottoTickets;

  public LottoTickets(List<LottoTicket> lottoTickets) {
    this.lottoTickets = lottoTickets;
  }

  public LottoStatistics getStatistics(LottoNumbers winningNumbers) {
    return new LottoStatistics(lottoTickets, winningNumbers);
  }

  public List<LottoTicket> getLottoTickets() {
    return lottoTickets;
  }
}
