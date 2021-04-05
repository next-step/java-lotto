package lotto.view;

import lotto.controller.LottoPurchaseController;
import lotto.controller.LottoWinInquiryController;
import lotto.controller.dto.LottoTicketPurchaseRequest;
import lotto.controller.dto.LottoTicketPurchaseResponse;

public class LottoAutoApplication {
    public static void main(String[] args) {
        InputView inputView = new InputView();
        ResultView resultView = new ResultView();
        LottoPurchaseController lottoPurchaseController = new LottoPurchaseController();
        LottoWinInquiryController lottoWinInquiryController = new LottoWinInquiryController();

        LottoTicketPurchaseRequest request = lottoPurchaseController.validatePurchasable(inputView.inputPurchaseInfo());
        LottoTicketPurchaseResponse lottoTicketPurchaseResponse = lottoPurchaseController.purchaseLottoTicket(inputView.inputPurchaseInfo(request));
        resultView.printPurchaseList(lottoTicketPurchaseResponse);
        resultView.printLottoWinStatistic(lottoWinInquiryController.inquiryWin(inputView.inputWinInquiry(lottoTicketPurchaseResponse.getLottoNumberList())));
    }
}
