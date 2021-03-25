package lotto.view;

import lotto.controller.LottoController;
import lotto.controller.dto.LottoAutoPurchaseResponse;
import lotto.controller.dto.WinInquiryResponse;
import lotto.controller.dto.WinStatistic;

import java.util.ArrayList;

public class LottoAutoApplication {
    public static void main(String[] args) {
        InputView inputView = new InputView();
        ResultView resultView = new ResultView();
        LottoController lottoController = new LottoController();

        LottoAutoPurchaseResponse lottoAutoPurchaseResponse = lottoController.purchaseLottoAutoTicket(inputView.inputPurchaseAmount());
        resultView.printPurchaseList(lottoAutoPurchaseResponse);

        System.out.println();

        // TODO: Controller 호출해 당첨결과 조회
        inputView.inputWinNumber(lottoAutoPurchaseResponse.getLottoNumberList());
        WinStatistic winStatistic = new WinStatistic(3, 5000, 1);
        ArrayList<WinStatistic> winStatisticList = new ArrayList<>();
        winStatisticList.add(winStatistic);
        WinInquiryResponse winInquiryResponse = new WinInquiryResponse(0.35, winStatisticList);
        resultView.printLottoWinStatistic(winInquiryResponse);
    }
}
