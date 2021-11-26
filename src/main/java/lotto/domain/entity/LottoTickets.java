package lotto.domain.entity;

import java.util.List;

public class LottoTickets {

  private List<LottoTicket> lottoList;

  public LottoTickets(List<LottoTicket> lottoTicketList) {
    this.lottoList = lottoTicketList;
  }

  public int getCountOfMatch(LottoTicket standard, int count) {
    return (int) lottoList.stream()
                          .map(ticket -> ticket.getMatchedCount(standard))
                          .filter(number -> number == count)
                          .count();
  }
}
