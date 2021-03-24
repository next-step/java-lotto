package step2.controller;

import step2.View.InputView;
import step2.View.ResultView;
import step2.View.RuntimeView;
import step2.dto.JudgeResponseDTO;
import step2.dto.LottoListDTO;
import step2.service.LottoService;

import java.util.List;

public class LottoController {

    private final InputView inputView = new InputView();
    private final RuntimeView runtimeView = new RuntimeView();
    private final ResultView resultView = new ResultView();

    private final LottoService lottoService = new LottoService();

    public void buyLotto() {
        LottoListDTO lottoList = lottoList();
        showLottoList(lottoList);
        JudgeResponseDTO result = result();
        showResult(result);
    }

    private void showResult(JudgeResponseDTO result){
        resultView.printResult(result);
    }

    private JudgeResponseDTO result(){
        String rawNumberString = inputView.lastWeekWinningLottoNumbers();
        int rawBonusNumber = inputView.lastWeekBonusLottoNumber();
        return lottoService.getLottoResult(rawNumberString, rawBonusNumber);
    }

    private LottoListDTO lottoList(){
        int rawAmount = inputView.moneyInput();
        int rawManualLottoCount = inputView.manualLottoCount();
        lottoService.verifyLottoCount(rawAmount,rawManualLottoCount);
        int change = lottoService.change(rawAmount, rawManualLottoCount);
        List<String> rawManualLottoList = inputView.manualLottoList(rawManualLottoCount);
        lottoService.verifyLottoList(rawManualLottoList);
        return lottoService.buyLotto(change, rawManualLottoList);
    }

    private void showLottoList(LottoListDTO lottoList){
        runtimeView.printLottoAmount(lottoList);
        runtimeView.printLottoNumbers(lottoList);
    }

}
