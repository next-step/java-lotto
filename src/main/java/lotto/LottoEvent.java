package lotto;

public interface LottoEvent {

  LottoRank getRank(LottoTicket lottoTicket);

  int getLottoTicketPrice();

  void setWinningLottoTicketNumberSet(LottoTicketNumberSet winningLottoTicketNumberSet);

  LottoTicket sellAutoLottoTicket();
}
