package nextstep.lotto.domain;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class LottoGame {
  private final Lotto winning;

  public LottoGame(final Set<LottoNumber> winningNumbers) {
    this.winning = new Lotto(winningNumbers);
  }

  public LottoResult match(final Lotto lotto) {
    final int matchCount = lotto.match(winning);
    return LottoResult.lottoResult(matchCount);
  }

  public List<LottoResult> match(final List<Lotto> lottos) {
    return lottos.stream().map(this::match).collect(Collectors.toList());
  }
}
