package step2.controller;

import step2.domain.LottoGameInfo;
import step2.domain.LottoWinningInformations;
import step2.domain.LottoWinningNumber;
import step2.view.InputView;
import step2.view.ResultView;

public class LottoController {
    private InputView inputView;
    private ResultView resultView;
    private LottoGameInfo lottoGameInfo;
    private LottoWinningNumber lottoWinningNumber;
    private LottoWinningInformations lottoWinningInformations;
    private int money;
    private String inputNumber;

    public LottoController() {
        inputView = new InputView();
        resultView = new ResultView();
    }

    public void startLottoGame() {
        money = inputView.inputMoney();
        lottoGameInfo = new LottoGameInfo(money);
        resultView.printTickets(lottoGameInfo.getLottoTickets());
        inputNumber = inputView.inputWinningNumber();
        lottoWinningNumber = new LottoWinningNumber(inputNumber);
        lottoWinningInformations = new LottoWinningInformations(lottoGameInfo, lottoWinningNumber);
        resultView.printWinningInfo(lottoWinningInformations);
    }
}
