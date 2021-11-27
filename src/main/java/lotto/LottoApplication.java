package lotto;

import lotto.domain.dto.LottoResult;
import lotto.domain.entity.Budget;
import lotto.domain.entity.LottoTickets;
import lotto.domain.service.AutoMaticLottoTicketCreator;
import lotto.domain.service.LottoService;
import lotto.view.InputView;
import lotto.view.ResultView;
import lotto.view.View;
import lotto.view.ViewImpl;

public class LottoApplication {

  public static void main(String[] args) {
    View view = new ViewImpl(InputView.getInstance(), ResultView.getInstance());

    Budget budget = view.getBudget();

    LottoService lottoService = new LottoService(new AutoMaticLottoTicketCreator());
    LottoTickets lottoTickets = lottoService.buyTheLottoTickets(budget);
    view.setBuyResult(lottoTickets);

    LottoResult lottoResult = lottoService.getLottoResult(view.getWinning(), lottoTickets);
    view.setLottoResult(lottoResult);
  }

}
