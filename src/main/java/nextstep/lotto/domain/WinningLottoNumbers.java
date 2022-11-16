package nextstep.lotto.domain;

import java.util.Set;

public class WinningLottoNumbers {
  private final Lotto winning;
  private final LottoNumber bonusNumber;

  public WinningLottoNumbers(final Set<LottoNumber> numbers, final LottoNumber bonusNumber) {
    if (numbers.contains(bonusNumber)) {
      throw new IllegalArgumentException("보너스 번호는 당첨 번호와 같을 수 없습니다.");
    }
    this.winning = new Lotto(numbers);
    this.bonusNumber = bonusNumber;
  }

  public LottoResult match(final Lotto lotto) {
    final int matchCount = winning.match(lotto);
    final boolean matchBonus = lotto.contains(bonusNumber);
    return LottoResult.lottoResult(matchCount, matchBonus);
  }


}
