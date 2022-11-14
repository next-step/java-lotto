package nextstep.lotto.domain;

import java.util.Set;

public class WinningLottoNumbers {
  private final Lotto winning;

  public WinningLottoNumbers(final Set<LottoNumber> numbers) {
    this.winning = new Lotto(numbers);
  }

  public LottoResult match(final Lotto lotto) {
    final int matchCount = winning.match(lotto);
    return LottoResult.lottoResult(matchCount);
  }
}
