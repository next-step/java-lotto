package lotto.view;

import lotto.controller.LottoPurchaseController;
import lotto.controller.dto.LottoPurchaseResponse;

public class LottoApplication {

    public static void main(String[] args) {
        InputView inputView = new InputView();
        OutputView outputView = new OutputView();
        LottoPurchaseController lottoPurchaseController = new LottoPurchaseController();

        LottoPurchaseResponse lottoPurchaseResponse = lottoPurchaseController.purchaseTickets(inputView.inputPurchaseInfo());
        outputView.printPurchaseResult(lottoPurchaseResponse);
    }
}
