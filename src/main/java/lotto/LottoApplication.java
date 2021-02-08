package lotto;

import lotto.controller.LottoController;
import lotto.domain.GoldenTicket;
import lotto.domain.LottoTickets;
import lotto.view.InputView;
import lotto.view.OutputView;

public class LottoApplication {

    public static void main(String[] args) {
        final InputView inputView = new InputView();
        final OutputView outputView = new OutputView();
        final LottoController lottoController = new LottoController(inputView, outputView);

        final LottoTickets lottoTickets = lottoController.purchaseLottoTickets();
        lottoController.printLottoTickets(lottoTickets);

        final GoldenTicket goldenTicket = lottoController.pickGoldenTicket();
        lottoController.printResults(lottoTickets, goldenTicket);
    }
}
