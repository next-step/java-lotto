package lotto.domain;

public class WinNumber {
  private LottoNumbers winNumber;
  private LottoNumber bonusNumber;

  public WinNumber(LottoNumbers winNumber, LottoNumber bonusNumber) {
    this.winNumber = winNumber;
    if (this.winNumber.contains(bonusNumber)) {
      throw new IllegalArgumentException("당첨번호와 같은 번호로 보너스 번호를 등록할 수 없습니다.");
    }
    this.bonusNumber = bonusNumber;
  }

  public Rank match(LottoNumbers userNumbers) {
    return Rank.valueOf(userNumbers.match(winNumber), userNumbers.match(bonusNumber));
  }
}
