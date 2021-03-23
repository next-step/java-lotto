package lotto.view;

import lotto.controller.LottoController;
import lotto.controller.dto.PurchaseLottoAutoResponse;

public class LottoAutoApplication {
    public static void main(String[] args) {
        InputView inputView = new InputView();
        ResultView resultView = new ResultView();
        LottoController lottoController = new LottoController();
        PurchaseLottoAutoResponse purchaseLottoAutoResponse = lottoController.purchaseLottoAutoTicket(inputView.inputPurchaseAmount());
        resultView.printPurchaseList(purchaseLottoAutoResponse);

        // TODO: InputView 를 통한 당첨번호 입력
        // TODO: Controller 호출해 당첨결과 조회
        // TODO: OutputView 를 통한 당첨결과 출력
    }
}
