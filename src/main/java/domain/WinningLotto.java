package domain;

import java.util.List;

public class WinningLotto extends Lotto{

  private final LottoNumber bonusNumber;

  public WinningLotto(List<LottoNumber> lottoNumbers, LottoNumber bonusNumber) {
    super(lottoNumbers);
    this.bonusNumber = bonusNumber;
  }

  public boolean isContainsBonusNumber(Lotto lotto) {
    return lotto.getLottoNumbers().contains(bonusNumber);
  }

}
