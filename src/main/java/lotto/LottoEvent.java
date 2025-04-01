package lotto;

public interface LottoEvent {

  LottoRank getRank(LottoTicket lottoTicket);

  int getLottoTicketPrice();

  LottoTicket sellAutoLottoTicket();
}
