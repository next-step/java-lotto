package lotto;

import lotto.controller.LottoController;
import lotto.service.LottoService;
import lotto.service.domain.LottoResultMaker;
import lotto.service.domain.LottoTicket;
import lotto.service.domain.LottoTicketRandomMaker;
import lotto.service.model.LottoResult;
import lotto.service.model.LottoTickets;
import lotto.service.value.LottoPrice;
import lotto.ui.InputView;
import lotto.ui.ResultView;

import java.util.List;

import static lotto.rule.LottoRule.MINIMUM_PRICE;

public class LottoApplication {
    private static InputView inputView = new InputView();
    private static LottoService lottoService = new LottoService(new LottoTicketRandomMaker(), new LottoResultMaker());
    private static LottoController lottoController = new LottoController(lottoService);
    private static ResultView resultView = new ResultView();

    public static void main(String[] args) {
        LottoTickets purchaseLottoTickets = purchaseLottoTickets();

        LottoTicket winningLottoTicket = getWinningLottoTicket();

        checkLottoResult(purchaseLottoTickets, winningLottoTicket);
    }

    private static LottoTickets purchaseLottoTickets() {
        LottoPrice purchasePrice = inputView.inputPurchasePrice();
        LottoTickets purchaseLottoTickets = lottoController.purchaseLottoTickets(purchasePrice);

        resultView.printPurchaseLottoTickets(purchaseLottoTickets);
        return purchaseLottoTickets;
    }

    private static LottoTicket getWinningLottoTicket() {
        List<Integer> winningLottoNumbers = inputView.inputWinningLottoNumberOfLastWeeks();

        return lottoController.getWinningLottoTicket(winningLottoNumbers);
    }

    private static void checkLottoResult(LottoTickets purchaseLottoTickets, LottoTicket winningLottoTicket) {
        LottoResult lottoResult = lottoController.checkLottoResult(purchaseLottoTickets, winningLottoTicket);
        resultView.printLottoResult(lottoResult, getPurchasePrice(purchaseLottoTickets.getCountOfLottoTickets()));
    }

    private static LottoPrice getPurchasePrice(Integer countOfLottoTickets) {
        return LottoPrice.from(countOfLottoTickets * MINIMUM_PRICE);
    }
}
