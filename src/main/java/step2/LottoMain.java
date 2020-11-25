package step2;

import step2.controller.LottoController;
import step2.domain.LottoDTO;
import step2.view.InputView;
import step2.view.ResultView;

import java.util.List;

public class LottoMain {

    private InputView inputView;
    private ResultView resultView;
    private LottoController lottoController;

    public LottoMain() {
        this.inputView = new InputView();
        this.resultView = new ResultView();
        this.lottoController = new LottoController();
    }

    public void run() {
        buyLotto();
        initWinNumber();
        findLottoResult();

    }

    private void buyLotto() {
        int fee = inputView.getFee();
        List<LottoDTO> lottoDTOS = lottoController.buyLotto(fee);
        resultView.showBoughtLotto(lottoDTOS);
    }

    private void initWinNumber() {
        String winNumberString = inputView.getWinNumbers();
        lottoController.initWinNumbers(winNumberString);
    }

    private void findLottoResult() {
        List<Long> lottoResult = lottoController.findLottoResult();
        resultView.showLottoResult(lottoResult);
    }


}
