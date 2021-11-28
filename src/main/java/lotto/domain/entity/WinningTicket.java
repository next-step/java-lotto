package lotto.domain.entity;

public class WinningTicket extends LottoTicket{

  private static final String DUPLICATED_NUMBER_MESSAGE = "기존의 당첨 숫자에 중복된 번호가 있습니다.";
  private final LottoNumber bonusNumber;

  public WinningTicket(LottoTicket lottoTicket, LottoNumber bonusNumber) {
    super(lottoTicket.getNumbers());
    if (lottoTicket.contains(bonusNumber)) {
      throw new IllegalArgumentException(DUPLICATED_NUMBER_MESSAGE);
    }
    this.bonusNumber = bonusNumber;
  }

  public LottoNumber getBonusNumber() {
    return bonusNumber;
  }
}
