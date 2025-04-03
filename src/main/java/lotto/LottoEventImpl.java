package lotto;

public class LottoEventImpl implements LottoEvent {

  LottoTicketSeller lottoTicketSeller = new LottoTicketSeller();
  LottoTicketNumberSet winningLottoTicketNumberSet;

  public LottoEventImpl() {
  }

  @Override
  public int getLottoTicketPrice() {
    return lottoTicketSeller.getLottoPrice();
  }

  @Override
  public void setWinningLottoTicketNumberSet(LottoTicketNumberSet winningLottoTicketNumberSet) {
    this.winningLottoTicketNumberSet = winningLottoTicketNumberSet;
  }

  @Override
  public LottoTicket sellAutoLottoTicket() {
    return lottoTicketSeller.sellAutoLottoTicket();
  }

  @Override
  public LottoRank getRank(LottoTicket lottoTicket) {
    return LottoRank.valueOfMatchedCount(lottoTicket.countMatchingNumbers(winningLottoTicketNumberSet));
  }
}
