package lotto.domain.entity;

import java.util.List;
import java.util.stream.Collectors;

public class LottoTickets {

  private final List<LottoTicket> lottoList;

  public LottoTickets(List<LottoTicket> lottoTicketList) {
    this.lottoList = lottoTicketList;
  }

  public int getCountOfMatch(LottoTicket standard, int count) {
    return (int) lottoList.stream()
                          .map(ticket -> ticket.getMatchedCount(standard))
                          .filter(number -> number == count)
                          .count();
  }

  public int size() {
    return lottoList.size();
  }

  @Override
  public String toString() {
    return lottoList.stream()
                    .map(LottoTicket::toString)
                    .collect(Collectors.joining(System.lineSeparator()));
  }
}
