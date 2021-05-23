package lotto;

import lotto.controller.LottoPurchaseController;
import lotto.controller.LottoWinController;
import lotto.controller.dto.LottoPurchaseResponse;
import lotto.controller.dto.WinInquiryRequest;
import lotto.controller.dto.WinInquiryResponse;
import lotto.view.InputView;
import lotto.view.OutputView;

public class LottoApplication {

    public static void main(String[] args) {
        LottoPurchaseController lottoPurchaseController = new LottoPurchaseController();
        LottoWinController lottoWinController = new LottoWinController();

        LottoPurchaseResponse lottoPurchaseResponse = lottoPurchaseController.purchaseTickets(InputView.inputPurchaseInfo());
        OutputView.printPurchaseResult(lottoPurchaseResponse);
        WinInquiryRequest winInquiryRequest = InputView.inputWinNumbers(lottoPurchaseResponse.getLottoNumbersDtoList());
        WinInquiryResponse winInquiryResponse = lottoWinController.inquiryWin(winInquiryRequest);
        OutputView.printWinResult(winInquiryResponse);
    }
}
