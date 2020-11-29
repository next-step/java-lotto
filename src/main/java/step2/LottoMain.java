package step2;

import step2.controller.LottoController;
import step2.domain.LottoRank;
import step2.domain.dto.LottoDTO;
import step2.view.InputView;
import step2.view.ResultView;

import java.math.BigDecimal;
import java.util.List;
import java.util.Map;

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
        findBenefit();
    }

    private void buyLotto() {
        int fee = inputView.getFee();
        List<LottoDTO> lottoDTOS = lottoController.buyLotto(fee);
        resultView.showBoughtLotto(lottoDTOS);
    }

    private void initWinNumber() {
        List<Integer> winningNumbersValue = inputView.getWinNumbers();
        lottoController.initWinNumbers(winningNumbersValue);
    }

    private void findLottoResult() {
        Map<LottoRank, Integer> lottoResult = lottoController.findLottoResult();
        resultView.showLottoResult(lottoResult);
    }

    private void findBenefit() {
        BigDecimal benefitPercent = lottoController.findBenefit();
        resultView.showBenefitPercent(benefitPercent);
    }
}
