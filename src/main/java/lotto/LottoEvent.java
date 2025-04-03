package lotto;

public class LottoEvent {

  LottoTicketSeller lottoTicketSeller = new LottoTicketSeller();
  LottoTicketNumberSet winningLottoTicketNumberSet;

  public LottoEvent() {
  }

  public int getLottoTicketPrice() {
    return lottoTicketSeller.getLottoPrice();
  }

  public void setWinningLottoTicketNumberSet(LottoTicketNumberSet winningLottoTicketNumberSet) {
    this.winningLottoTicketNumberSet = winningLottoTicketNumberSet;
  }

  public LottoTicket sellAutoLottoTicket() {
    return lottoTicketSeller.sellAutoLottoTicket();
  }

  public LottoRank getRank(LottoTicket lottoTicket) {
    return LottoRank.valueOfMatchedCount(lottoTicket.countMatchingNumbers(winningLottoTicketNumberSet));
  }
}
