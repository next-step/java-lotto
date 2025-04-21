package controller;

import model.*;
import service.LottoService;
import view.InputView;
import view.ResultView;

public class LottoController {
    private final LottoService lottoService;;

    public LottoController() {
        this.lottoService = new LottoService();
    }

    public void run() {
        InputView inputView = new InputView();
        ResultView resultView = new ResultView();

        int purchasePrice = inputView.getPurchasePrice();
        Lottos lottos = lottoService.create(purchasePrice);

        resultView.printLottos(lottos);

        String winningNumbersStr = inputView.getLottoWinningNumbers();
        int bonusNumber = inputView.getBonusNumber();
        LottoResult result = lottoService.result(lottos, winningNumbersStr, bonusNumber);
        resultView.printResult(result);
    }
}
