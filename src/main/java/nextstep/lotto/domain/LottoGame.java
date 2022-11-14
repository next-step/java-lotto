package nextstep.lotto.domain;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class LottoGame {
  private final WinningLottoNumbers winning;

  public LottoGame(final Set<LottoNumber> winningNumbers) {
    this.winning = new WinningLottoNumbers(winningNumbers);
  }

  public List<LottoResult> match(final List<Lotto> lottos) {
    return lottos.stream()
      .map(this::match)
      .collect(Collectors.toList());
  }

  private LottoResult match(final Lotto lotto) {
    return winning.match(lotto);
  }

}
