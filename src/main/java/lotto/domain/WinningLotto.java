package lotto.domain;

import java.util.List;

public class WinningLotto extends Lotto {
  private final LottoNumber bonusNumber;

  public WinningLotto(List<LottoNumber> numbers, LottoNumber bonusNumber) {
    super(numbers);
    validate(numbers, bonusNumber);
    this.bonusNumber = bonusNumber;
  }

  private void validate(List<LottoNumber> numbers, LottoNumber bonusNumber) {
    if (numbers.contains(bonusNumber)) {
      throw new IllegalArgumentException("보너스 번호는 당첨 번호와 중복될 수 없습니다.");
    }
  }

  public boolean hasBonus(Lotto otherLotto) {
    return otherLotto.contains(bonusNumber);
  }
}