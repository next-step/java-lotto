package lotto;

import java.util.Arrays;

public class LastWeekWinLotto {

  private LottoNumbers lottoNumbers;
  private int bonusNumber;

  public LastWeekWinLotto(String inputWinLottoNumber, int bonusNumber) {
    lottoNumbers = new Lotto(inputWinLottoNumber).getNumbers();
    this.bonusNumber = bonusNumber;
    validate();
  }

  private void validate() {
    duplicateNumberCheck();
  }

  private void duplicateNumberCheck() {
    if(lottoNumbers.hasBonusNumber(bonusNumber)) {
      throw new IllegalArgumentException("당첨 번호와 보너스볼 번호가 일치할 수 업습니다.");
    }
  }

  public Rank getResult(Lotto lotto) {
    int matchCount = getMatchCount(lotto);
    boolean hasBonus = hasBonusNumber(lotto);
    return Arrays.stream(Rank.values())
        .filter(rank -> rank.getBoundaryCount() == matchCount)
        .filter(rank -> rank.isBonusMatch() == hasBonus)
        .findFirst()
        .orElse(Rank.MISS);
  }

  public boolean hasBonusNumber(Lotto lotto) {
    return lotto.hasBonusNumber(bonusNumber);
  }

  public int getMatchCount(Lotto lotto) {
    return lottoNumbers.countSameNumber(lotto.getNumbers());
  }

}
