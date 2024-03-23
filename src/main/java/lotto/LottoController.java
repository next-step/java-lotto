package lotto;

import java.util.List;

public class LottoController {
    private LottoService lottoService = new LottoService();
    private OutputView outputView = new OutputView();

    public void start() {
        List<LottoTicket> tickets  = lottoService.purchaseLotto(14000);
        outputView.displayLottoTickets(tickets);
    }

}
