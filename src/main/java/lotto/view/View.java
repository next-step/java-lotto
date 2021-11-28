package lotto.view;

import lotto.domain.dto.LottoResult;
import lotto.domain.entity.Budget;
import lotto.domain.entity.LottoNumber;
import lotto.domain.entity.LottoTicket;
import lotto.domain.entity.LottoTickets;

public interface View {

  Budget getBudget();

  LottoTicket getWinning();

  LottoNumber getBonus();

  void setBuyResult(LottoTickets lottoTickets);

  void setLottoResult(LottoResult result);

}
