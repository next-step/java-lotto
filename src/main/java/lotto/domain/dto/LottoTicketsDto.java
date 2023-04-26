package lotto.domain.dto;

import java.util.List;

public class LottoTicketsDto {
  public final List<List<Integer>> lottoTickets;

  public LottoTicketsDto(List<List<Integer>> lottoTickets) {
    this.lottoTickets = lottoTickets;
  }
}
