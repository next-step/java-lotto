package lotto.domain;

import java.util.Set;

public class WinningLotto {

  private static final String INVALID_BONUS_MESSAGE = "보너스볼은 로또와 중복된 숫자일 수 없습니다.";

  private final Lotto lotto;

  private final LottoNumber bonus;

  public WinningLotto(Lotto lotto, LottoNumber bonus) {
    validateBonus(lotto, bonus);
    this.lotto = lotto;
    this.bonus = bonus;
  }

  private void validateBonus(Lotto lotto, LottoNumber bonus) {
    if (lotto.contains(bonus)) {
      throw new IllegalArgumentException(INVALID_BONUS_MESSAGE);
    }
  }

  public static WinningLotto create(Set<Integer> lottoNumbers, int bonus) {
    Lotto lotto = Lotto.create(lottoNumbers);
    LottoNumber bonusNumber = LottoNumber.of(bonus);
    return new WinningLotto(lotto, bonusNumber);
  }

  public Lotto getLotto() {
    return lotto;
  }

  public boolean matchBonus(Lotto other) {
    return other.contains(bonus);
  }
}
