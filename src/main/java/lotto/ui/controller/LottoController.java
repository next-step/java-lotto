package lotto.ui.controller;

import lotto.application.dto.LottoRequest;
import lotto.application.dto.LottoResponse;
import lotto.application.service.LottoService;
import lotto.ui.InputView;
import lotto.ui.ResultView;


public class LottoController {

    public static void main(String[] args) {
        InputView inputView = new InputView();
        Integer amount = inputView.inputAmount();
        LottoRequest request = new LottoRequest(amount,
                                                inputView.calculateLottoCount(amount),
                                                inputView.inputWinningNumber());

        LottoService service = new LottoService();
        LottoResponse response = service.calculateBenefit(request);

        ResultView resultView = new ResultView();
        resultView.showResult(response);
    }
}
