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
        int amount = inputView.moneyInput();
        int manualLottoCount = manualLottoCount(amount);
        int change = lottoService.change(amount, manualLottoCount);
        List<String> rawManualLottoList = rawManualLottoList(manualLottoCount);
        int autoLottoCount = lottoService.capacity(change);

        LottoListDTO lottoList = lottoService.buyLotto(rawManualLottoList, autoLottoCount);
        showLottoList(manualLottoCount, autoLottoCount, lottoList);
        JudgeResponseDTO result = result();
        resultView.printResult(result);
    }

    private int manualLottoCount(int amount) {
        int manualLottoCount = inputView.manualLottoCount();
        lottoService.verifyLottoCount(amount, manualLottoCount);
        return manualLottoCount;
    }

    private List<String> rawManualLottoList(int manualLottoCount) {
        List<String> rawManualLottoList = inputView.manualLottoList(manualLottoCount);
        lottoService.verifyLottoList(rawManualLottoList);
        return rawManualLottoList;
    }

    private JudgeResponseDTO result() {
        String rawNumberString = inputView.lastWeekWinningLottoNumbers();
        int rawBonusNumber = inputView.lastWeekBonusLottoNumber();
        return lottoService.getLottoResult(rawNumberString, rawBonusNumber);
    }

    private void showLottoList(int manualLottoCount, int autoLottoCount, LottoListDTO lottoList) {
        runtimeView.printLottoAmount(manualLottoCount, autoLottoCount);
        runtimeView.printLottoNumbers(lottoList);
    }

}
