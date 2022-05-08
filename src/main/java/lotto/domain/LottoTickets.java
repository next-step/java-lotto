package lotto.domain;

import java.util.Collections;
import java.util.List;

public class LottoTickets {

  private static final String EMPTY_OR_NULL_LOTTO_TICKETS = "로또 그룹은 빈 값일 수 없습니다.";

  private final List<LottoTicket> lottoTickets;

  public LottoTickets(List<LottoTicket> lottoTickets) {
    if (lottoTickets == null || lottoTickets.isEmpty()) {
      throw new IllegalArgumentException(EMPTY_OR_NULL_LOTTO_TICKETS);
    }
    this.lottoTickets = lottoTickets;
  }

  public int size() {
    return lottoTickets.size();
  }

  public List<LottoTicket> tickets() {
    return Collections.unmodifiableList(lottoTickets);
  }

  public int getMatchedCountPerPrize(Prizes prize, WinNumbers winNumbers) {
    return (int) lottoTickets.stream()
        .map(lottoTicket -> lottoTicket.countMatched(winNumbers.getTicket()))
        .map(Prizes::of)
        .filter(prize::equals)
        .count();
  }
}
