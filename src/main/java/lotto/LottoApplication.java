package lotto;

import lotto.controller.LottoController;
import lotto.service.LottoService;
import lotto.service.domain.LottoResultMaker;
import lotto.service.domain.LottoTicketRandomMaker;
import lotto.service.domain.WinningLottoTicket;
import lotto.service.model.LottoResult;
import lotto.service.model.LottoTickets;
import lotto.service.value.LottoPrice;
import lotto.ui.InputView;
import lotto.ui.ResultView;

import java.util.List;

public class LottoApplication {
    private static InputView inputView = new InputView();
    private static LottoService lottoService = new LottoService(new LottoTicketRandomMaker(), new LottoResultMaker());
    private static LottoController lottoController = new LottoController(lottoService);
    private static ResultView resultView = new ResultView();

    public static void main(String[] args) {
        LottoPrice purchasePrice = inputView.inputPurchasePrice();
        LottoTickets purchaseLottoTickets = lottoController.purchaseLottoTickets(purchasePrice);
        resultView.printPurchaseLottoTickets(purchaseLottoTickets);

        List<Integer> winningLottoNumbers = inputView.inputWinningLottoNumberOfLastWeeks();
        Integer bonusNumber = inputView.inputBonusNumber();
        WinningLottoTicket winningLottoTicket = lottoController.getWinningLottoTicket(winningLottoNumbers, bonusNumber);

        LottoResult lottoResult = lottoController.checkLottoResult(purchaseLottoTickets, winningLottoTicket);
        resultView.printLottoResult(lottoResult, purchasePrice);
    }
}
