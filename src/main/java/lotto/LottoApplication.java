package lotto;

import lotto.controller.LottoController;
import lotto.service.LottoService;
import lotto.service.domain.LottoResultMaker;
import lotto.service.domain.WinningLottoTicket;
import lotto.service.domain.factory.LottoTicketFactory;
import lotto.service.model.LottoTickets;
import lotto.ui.InputView;
import lotto.ui.ResultView;

public class LottoApplication {
    public static void main(String[] args) {
        LottoController lottoController = new LottoController(new LottoService(new LottoResultMaker(),
                                                                               new LottoTicketFactory()),
                                                              new InputView(),
                                                              new ResultView());

        LottoTickets lottoTickets = lottoController.purchaseLottoTickets();

        WinningLottoTicket winningLottoTicket = lottoController.getWinningLottoTicket();

        lottoController.checkLottoResult(lottoTickets, winningLottoTicket);
    }
}
