package lotto.model;

import lotto.domain.LottoTicket;
import lotto.domain.LottoWiningNumbers;

public class LottoRequestVO {
  private LottoTicket lottoTicket;
  private LottoWiningNumbers winingNumbers;

  public LottoRequestVO(LottoTicket lottoTicket, LottoWiningNumbers winingNumbers) {
    this.lottoTicket = lottoTicket;
    this.winingNumbers = winingNumbers;
  }

  public LottoTicket getLottoTicket() {
    return lottoTicket;
  }

  public LottoWiningNumbers getWiningNumbers() {
    return winingNumbers;
  }

  public void setLottoTicket(LottoTicket lottoTicket) {
    this.lottoTicket = lottoTicket;
  }

  public void setWiningNumbers(LottoWiningNumbers winingNumbers) {
    this.winingNumbers = winingNumbers;
  }
}
