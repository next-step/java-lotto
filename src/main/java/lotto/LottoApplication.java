package lotto;

import lotto.controller.LottoController;
import lotto.domain.LottoNumber;
import lotto.domain.LottoTicket;
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

        final LottoTicket lottoTicket = lottoController.makeWinningTicket();
        final LottoNumber lottoNumber = lottoController.makeBonusBall();
        lottoController.printResults(lottoTickets, lottoTicket, lottoNumber);
    }
}
