package lotto.domain;

import java.util.Collections;
import java.util.List;

public class LottoTicket {

  private final List<Lotto> lottos;

  public LottoTicket(List<Lotto> lottos) {
    this.lottos = lottos;
  }

  public List<Lotto> getLottos() {
    return Collections.unmodifiableList(lottos);
  }
}
