package lotto.domain;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class LottoTicket {

  private final List<Lotto> lottos;

  public LottoTicket(List<Lotto> lottos) {
    this.lottos = lottos;
  }

  public LottoResult match(WinLotto winLotto) {
    return new LottoResult(lottos.stream()
        .map(winLotto::match)
        .collect(Collectors.toList()));
  }

  public List<Lotto> getLottos() {
    return Collections.unmodifiableList(lottos);
  }


}
