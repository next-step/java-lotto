package domain;

import java.util.Arrays;
import java.util.List;

import static domain.LottoResult.NONE;

public class WinningLotto {
  private final static int bonusNumberTargetMatchedCount = LottoResult.SECOND.matchCount();
  private final List<LottoNumber> winningNumbers;
  private final LottoNumber bonusNumber;

  public WinningLotto(final List<LottoNumber> winningNumbers, final LottoNumber bonusNumber) {
    this.winningNumbers = winningNumbers;
    this.bonusNumber = bonusNumber;
  }

  public LottoResult getResult(Lotto lotto) {
    int matchedCount = new Lotto(winningNumbers).matchCount(lotto);

    if (isBonusNumberTarget(matchedCount)) {
      return lotto.contains(bonusNumber) ? LottoResult.SECOND : LottoResult.THIRD;
    }

    return Arrays.stream(LottoResult.values())
        .filter(lottoResult -> lottoResult.matchCount() == matchedCount)
        .findFirst()
        .orElse(NONE);
  }

  private boolean isBonusNumberTarget(int matchedCount) {
    return bonusNumberTargetMatchedCount == matchedCount;
  }
}
