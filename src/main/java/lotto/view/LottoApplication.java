package lotto.view;

import lotto.controller.LottoPurchaseController;
import lotto.controller.LottoWinController;
import lotto.controller.dto.LottoPurchaseResponse;
import lotto.controller.dto.WinInquiryRequest;
import lotto.controller.dto.WinInquiryResponse;

public class LottoApplication {

    public static void main(String[] args) {
        InputView inputView = new InputView();
        OutputView outputView = new OutputView();
        LottoPurchaseController lottoPurchaseController = new LottoPurchaseController();
        LottoWinController lottoWinController = new LottoWinController();

        LottoPurchaseResponse lottoPurchaseResponse = lottoPurchaseController.purchaseTickets(inputView.inputPurchaseInfo());
        outputView.printPurchaseResult(lottoPurchaseResponse);
        WinInquiryRequest winInquiryRequest = inputView.inputWinNumbers(lottoPurchaseResponse.getLottoNumbersDtoList());
        WinInquiryResponse winInquiryResponse = lottoWinController.inquiryWin(winInquiryRequest);
        outputView.printWinResult(winInquiryResponse);
    }
}
