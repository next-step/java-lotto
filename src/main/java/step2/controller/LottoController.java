package step2.controller;

import step2.View.InputView;
import step2.View.ResultView;
import step2.View.RuntimeView;
import step2.domain.Lotto;
import step2.domain.Money;
import step2.dto.JudgeResponse;
import step2.dto.ShopResponse;
import step2.service.LottoService;

public class LottoController {

    private final InputView inputView = new InputView();
    private final RuntimeView runtimeView = new RuntimeView();
    private final ResultView resultView = new ResultView();

    private final LottoService lottoService = new LottoService();

    public void buyManualLotto() {
        Money money = inputView.getMoneyInput();
        ShopResponse shopResponse = lottoService.buyManualLotto(money);

        runtimeView.printLottoAmount(shopResponse);
        runtimeView.printLottoNumbers(shopResponse);

        Lotto winningLotto = inputView.getLastWeekWiningLottoNumbers();
        JudgeResponse judgeResponse = lottoService.getLottoResult(shopResponse, winningLotto);
        resultView.printResult(judgeResponse);
    }

}
