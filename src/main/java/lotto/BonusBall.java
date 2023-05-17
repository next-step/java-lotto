package lotto;

public class BonusBall {

  private final LottoNo bonusNumber;

  public BonusBall(WinningNumbers winningNumbers, int bonusNumber) {
    if (winningNumbers.has(LottoNo.of(bonusNumber))) {
      throw new IllegalArgumentException("보너스 볼은 당첨 번호와 중복되지 않아야합니다.");
    }
    this.bonusNumber = LottoNo.of(bonusNumber);
  }

  public LottoNo getBonusNumber() {
    return bonusNumber;
  }

  public boolean equals(LottoNo lottoNo) {
    return bonusNumber.equals(lottoNo);
  }
}
