package lotto.model;

public class WinningLotto {

  private final Lotto lotto;
  private final LottoNumber bonusNumber;

  public WinningLotto(Lotto lotto, LottoNumber bonusNumber) {
    if (lotto.has(bonusNumber)) {
      throw new IllegalArgumentException("보너스 볼이 당첨번호와 중복됩니다.");
    }

    this.lotto = lotto;
    this.bonusNumber = bonusNumber;
  }

  public static WinningLotto newInstanceByStrArr(String[] numberArr, LottoNumber bonusNumber) {
    return new WinningLotto(LottoFactory.createLottoByStrArr(numberArr), bonusNumber);
  }

  public Lotto getLotto() {
    return lotto;
  }

  public PrizeTier getPrizeTier(Lotto target) {
    int numberOfMatches = lotto.numberOfMatchesTo(target);

    return PrizeTier.valueOf(new MatchCnt(lotto.numberOfMatchesTo(target),
        numberOfMatches == 5 && target.has(bonusNumber)));
  }
}
