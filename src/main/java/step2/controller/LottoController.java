package step2.controller;

import step2.View.InputView;
import step2.View.ResultView;
import step2.View.RuntimeView;
import step2.dto.LottoDTO;
import step2.dto.MoneyDTO;
import step2.dto.JudgeResponseDTO;
import step2.dto.ShopResponseDTO;
import step2.service.LottoService;

public class LottoController {

    private final InputView inputView = new InputView();
    private final RuntimeView runtimeView = new RuntimeView();
    private final ResultView resultView = new ResultView();

    private final LottoService lottoService = new LottoService();

    public void buyManualLotto() {
        int rawAmount = inputView.getMoneyInput();
        MoneyDTO money = lottoService.convertRawAmountToMoney(rawAmount);
        ShopResponseDTO shopResponse = lottoService.buyManualLotto(money);

        runtimeView.printLottoAmount(shopResponse);
        runtimeView.printLottoNumbers(shopResponse);

        String rawNumberString = inputView.getLastWeekWiningLottoNumbers();
        LottoDTO winningLotto = lottoService.convertRawNumberStringToLotto(rawNumberString);
        JudgeResponseDTO judgeResponse = lottoService.getLottoResult(shopResponse, winningLotto);
        resultView.printResult(judgeResponse);
    }

}
