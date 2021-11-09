package lotto;

import lotto.controller.LottoController;
import lotto.controller.dto.LottoPurchaseRequest;
import lotto.service.domain.LottoTicket;
import lotto.service.model.LottoResult;
import lotto.service.model.LottoTickets;
import lotto.service.value.LottoPrice;
import lotto.ui.InputView;
import lotto.ui.ResultView;

import java.util.List;

public class LottoApplication {
    private static final Integer MINIMUM_PRICE = 1_000;

    private static InputView inputView = new InputView();
    private static LottoController lottoController = new LottoController();
    private static ResultView resultView = new ResultView();

    public static void main(String[] args) {
        LottoTickets purchaseLottoTickets = purchaseLottoTickets();

        LottoTicket winningLottoTicket = getWinningLottoTicket();

        checkLottoResult(purchaseLottoTickets, winningLottoTicket);
    }

    private static LottoTickets purchaseLottoTickets() {
        LottoPrice purchasePrice = inputView.inputPurchasePrice();
        LottoTickets lottoTickets = lottoController.purchaseLottoTickets(LottoPurchaseRequest.from(purchasePrice));

        resultView.printLottoTickets(lottoTickets);
        return lottoTickets;
    }

    private static LottoTicket getWinningLottoTicket() {
        List<Integer> winningNumbers = inputView.inputLastWeeksWinningNumber();

        return lottoController.getWinningLottoTicket(winningNumbers);
    }

    private static void checkLottoResult(LottoTickets purchaseLottoTickets, LottoTicket winningLottoTicket) {
        LottoResult lottoResult = lottoController.checkLottoResult(purchaseLottoTickets, winningLottoTicket);
        resultView.printLottoResult(lottoResult, getPurchasePrice(purchaseLottoTickets.getLottoTicketsCount()));
    }

    private static LottoPrice getPurchasePrice(Integer ticketCount) {
        return LottoPrice.from(ticketCount * MINIMUM_PRICE);
    }
}
