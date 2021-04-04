package lotto.view;

import lotto.controller.LottoAutoPurchaseController;
import lotto.controller.LottoWinInquiryController;
import lotto.controller.dto.LottoTicketPurchaseResponse;

public class LottoAutoApplication {
    public static void main(String[] args) {
        InputView inputView = new InputView();
        ResultView resultView = new ResultView();
        LottoAutoPurchaseController lottoAutoPurchaseController = new LottoAutoPurchaseController();
        LottoWinInquiryController lottoWinInquiryController = new LottoWinInquiryController();

        LottoTicketPurchaseResponse lottoTicketPurchaseResponse = lottoAutoPurchaseController.purchaseLottoAutoTicket(inputView.inputPurchaseInfo());
        resultView.printPurchaseList(lottoTicketPurchaseResponse);
        System.out.println();
        resultView.printLottoWinStatistic(lottoWinInquiryController.inquiryWin(inputView.inputWinInquiry(lottoTicketPurchaseResponse.getLottoNumberList())));
    }
}
