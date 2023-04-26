package lotto.domain;

public class WinningTicket {

  private static final String ILLEGAL_BONUS_MESSAGE = "보너스 번호는 당첨 번호를 제외한 숫자이어야 합니다. 현재 번호 : ";
  private final LottoTicket winningLottoTicket;
  private final LottoNumber bonusNumber;

  public WinningTicket(LottoTicket winningLottoTicket, LottoNumber bonusNumber) {
    this.winningLottoTicket = winningLottoTicket;
    this.bonusNumber = validatedBonusNumber(bonusNumber);
  }

  public int matchLottoCount(LottoTicket lottoTicket) {
    return lottoTicket.matchLottoCount(winningLottoTicket);
  }

  public boolean containsBonusNumber(LottoTicket lottoTicket) {
    return lottoTicket.containsLottoNumbers(bonusNumber);
  }

  private LottoNumber validatedBonusNumber(LottoNumber bonusNumber) {
    if (hasBonusNumber(bonusNumber)) {
      throw new IllegalArgumentException(ILLEGAL_BONUS_MESSAGE + bonusNumber);
    }

    return bonusNumber;
  }

  private boolean hasBonusNumber(LottoNumber bonusNumber) {
    return winningLottoTicket.containsLottoNumbers(bonusNumber);
  }
}
