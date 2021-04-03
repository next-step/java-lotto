package lotto.view;

import lotto.controller.LottoAutoPurchaseController;
import lotto.controller.LottoWinInquiryController;
import lotto.controller.dto.LottoAutoPurchaseResponse;

public class LottoAutoApplication {
    public static void main(String[] args) {
        InputView inputView = new InputView();
        ResultView resultView = new ResultView();
        LottoAutoPurchaseController lottoAutoPurchaseController = new LottoAutoPurchaseController();
        LottoWinInquiryController lottoWinInquiryController = new LottoWinInquiryController();

        LottoAutoPurchaseResponse lottoAutoPurchaseResponse = lottoAutoPurchaseController.purchaseLottoAutoTicket(inputView.inputPurchaseAmount());
        resultView.printPurchaseList(lottoAutoPurchaseResponse);
        System.out.println();
        resultView.printLottoWinStatistic(lottoWinInquiryController.inquiryWin(inputView.inputWinInquiry(lottoAutoPurchaseResponse.getLottoNumberList())));
    }
}
