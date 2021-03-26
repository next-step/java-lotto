package lotto.view;

import lotto.controller.LottoController;
import lotto.controller.dto.LottoAutoPurchaseResponse;

public class LottoAutoApplication {
    public static void main(String[] args) {
        InputView inputView = new InputView();
        ResultView resultView = new ResultView();
        LottoController lottoController = new LottoController();

        LottoAutoPurchaseResponse lottoAutoPurchaseResponse = lottoController.purchaseLottoAutoTicket(inputView.inputPurchaseAmount());
        resultView.printPurchaseList(lottoAutoPurchaseResponse);
        System.out.println();
        resultView.printLottoWinStatistic(lottoController.inquiryWin(inputView.inputWinNumber(lottoAutoPurchaseResponse.getLottoNumberList())));
    }
}
