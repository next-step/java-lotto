package lotto.dto;

import java.util.List;
import java.util.stream.Collectors;
import lotto.LottoTicket;

public class LottoTicketsDTO {

  private final List<String> tickets;

  public LottoTicketsDTO(List<LottoTicket> tickets) {
    this.tickets = tickets.stream()
        .map(LottoTicket::toString)
        .collect(Collectors.toList());
  }

  public List<String> getTickets() {
    return this.tickets;
  }
}
