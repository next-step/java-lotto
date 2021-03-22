package step2.controller;

import step2.View.InputView;
import step2.View.ResultView;
import step2.View.RuntimeView;
import step2.dto.JudgeDTO;
import step2.dto.JudgeDTO.JudgeResponseDTO;
import step2.dto.ShopResponseDTO;
import step2.service.LottoService;

public class LottoController {

    private final InputView inputView = new InputView();
    private final RuntimeView runtimeView = new RuntimeView();
    private final ResultView resultView = new ResultView();

    private final LottoService lottoService = new LottoService();

    public void buyManualLotto() {
        int rawAmount = inputView.getMoneyInput();
        ShopResponseDTO shopResponse = lottoService.buyManualLotto(rawAmount);

        runtimeView.printLottoAmount(shopResponse);
        runtimeView.printLottoNumbers(shopResponse);

        String rawNumberString = inputView.getLastWeekWiningLottoNumbers();
        int rawBonusNumber = inputView.getLastWeekBonusLottoNumber();
        JudgeResponseDTO judgeResponse = lottoService.getLottoResult(shopResponse, rawNumberString, rawBonusNumber);
        resultView.printResult(judgeResponse);
    }

}
