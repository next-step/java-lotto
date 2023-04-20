package lotto.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class LottoTickets {
  private final List<LottoTicket> lottoTickets = new ArrayList<>();

  public List<LottoTicket> unmodifiedLottoTickets() {
    return Collections.unmodifiableList(lottoTickets);
  }

  public static LottoTickets createRandomLottoTickets(int tryCount) {
    LottoTickets randomLottoTickets = new LottoTickets();

    for (int i = 0; i < tryCount; i++) {
      randomLottoTickets.addRandomTicket();
    }

    return randomLottoTickets;
  }

  private void addRandomTicket() {
    lottoTickets.add(new LottoTicket(new RandomLottoStrategy()));
  }
}
