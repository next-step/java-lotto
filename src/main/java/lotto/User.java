package lotto;

import java.util.List;

public interface User {

  List<LottoRank> evaluateLottoTickets();

  void buyAllLottoTickets();

  List<LottoTicket> getLottoTickets();

  double calculateProfitRate();
}
