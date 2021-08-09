package lotto.domain;

import java.util.List;
import lotto.message.Message;

public class WinLottoInfo {

  private Lotto lotto;

  private LottoNumber bonusNumber;

  public WinLottoInfo(final Lotto lotto, final int bonus) {
    validation(lotto, bonus);
    this.lotto = lotto;
    this.bonusNumber = new LottoNumber(bonus);
  }

  private void validation(final Lotto lotto, final int bonus) {
    if(lotto.getLotto().contains(new LottoNumber(bonus))){
      throw new IllegalArgumentException(Message.MSG_ERROR_DUPLICATE_BONUS);
    }
  }

  public Lotto getLotto() {
    return lotto;
  }

  public LottoNumber getBonusLottoNumber() {
    return bonusNumber;
  }

  public List<LottoNumber> getLottoNumbers(){
    return lotto.getLotto();
  }
}