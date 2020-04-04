package step2.controller;

import step2.domain.LottoGameInfo;
import step2.view.InputView;
import step2.view.ResultView;

public class LottoController {
    private InputView inputView;
    private ResultView resultView;
    private LottoGameInfo lottoGameInfo;
    private int money;

    public LottoController() {
        inputView = new InputView();
        resultView = new ResultView();
    }

    public void startLottoGame() {
        money = inputView.inputMoney();
        lottoGameInfo = new LottoGameInfo(money);
        resultView.printTickets(lottoGameInfo.getLottoTickets());
    }
}
