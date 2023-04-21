package lotto.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class LottoTickets {
  private final List<LottoTicket> lottoTickets = new ArrayList<>();

  public List<LottoTicket> unmodifiedLottoTickets() {
    return Collections.unmodifiableList(lottoTickets);
  }

  public List<Integer> matchesLottoTickets(LottoTicket winningLottoNumbers) {
    return lottoTickets.stream()
            .map(t -> t.matchLottoCount(winningLottoNumbers))
            .collect(Collectors.toList());
  }

  public void addLottoTicket(LottoStrategy lottoStrategy) {
    lottoTickets.add(new LottoTicket(lottoStrategy));
  }
}
