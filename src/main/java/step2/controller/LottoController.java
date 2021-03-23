package step2.controller;

import step2.View.InputView;
import step2.View.ResultView;
import step2.View.RuntimeView;
import step2.dto.JudgeResponseDTO;
import step2.dto.LottoListDTO;
import step2.service.LottoService;

public class LottoController {

    private final InputView inputView = new InputView();
    private final RuntimeView runtimeView = new RuntimeView();
    private final ResultView resultView = new ResultView();

    private final LottoService lottoService = new LottoService();

    public void buyManualLotto() {
        int rawAmount = inputView.getMoneyInput();
        LottoListDTO lottoList = lottoService.buyLotto(rawAmount);

        runtimeView.printLottoAmount(lottoList);
        runtimeView.printLottoNumbers(lottoList);

        String rawNumberString = inputView.getLastWeekWiningLottoNumbers();
        int rawBonusNumber = inputView.getLastWeekBonusLottoNumber();
        JudgeResponseDTO judgeResponse = lottoService.getLottoResult(rawNumberString, rawBonusNumber);
        resultView.printResult(judgeResponse);
    }

}
