package lotto.dto;

import lotto.LottoTicket;
import lotto.LottoTickets;

import java.util.List;
import java.util.stream.Collectors;

public class LottoTicketsDto {
  private List<List<Integer>> lottoTickets;

  public LottoTicketsDto(LottoTickets lottoTickets) {
    this.lottoTickets = lottoTickets.getTickets().stream()
                                    .map(LottoTicket::getNumbers)
                                    .collect(Collectors.toList());
  }

  public List<List<Integer>> getLottoTickets() {
    return lottoTickets;
  }
}
