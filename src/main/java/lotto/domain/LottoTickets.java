package lotto.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class LottoTickets {
  private final List<LottoTicket> lottoTickets;

  public LottoTickets() {
    this.lottoTickets = new ArrayList<>();
  }

  public List<LottoTicket> unmodifiedLottoTickets() {
    return Collections.unmodifiableList(lottoTickets);
  }

  public List<Integer> matchesLottoTickets(LottoTicket winningLottoNumbers) {
    return lottoTickets.stream()
            .map(lottoTicket -> lottoTicket.matchLottoCount(winningLottoNumbers))
            .collect(Collectors.toList());
  }

  public void addLottoTicket(LottoTicket lottoTicket) {
    lottoTickets.add(lottoTicket);
  }
}
