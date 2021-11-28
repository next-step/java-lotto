package lotto.domain.entity;

import java.util.List;
import java.util.stream.Collectors;

public class LottoTickets {

  private final List<LottoTicket> lottoList;

  public LottoTickets(List<LottoTicket> lottoTicketList) {
    this.lottoList = lottoTicketList;
  }

  public int size() {
    return lottoList.size();
  }

  public List<LottoTicket> getLottoList() {
    return lottoList;
  }

  @Override
  public String toString() {
    return lottoList.stream()
                    .map(LottoTicket::toString)
                    .collect(Collectors.joining(System.lineSeparator()));
  }
}
