package lotto.domain;

import java.util.Collections;
import java.util.List;

public class WinLotto {

  private final LottoTicket lottoTicket;
  private final LottoNumber bonusNumber;

  public WinLotto(LottoTicket lottoTicket, LottoNumber bonusNumber) {
    this.lottoTicket = lottoTicket;
    this.bonusNumber = bonusNumber;
  }

  public List<LottoNumber> getLottoNumbers() {
    return Collections.unmodifiableList(lottoTicket.getLottoNumbers());
  }

  public LottoNumber getBonusNumber() {
    return bonusNumber;
  }
}
