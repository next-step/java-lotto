package lotto.controller;

import lotto.domain.BuyingLottos;
import lotto.domain.WanLottoNumbers;
import lotto.view.InputView;
import lotto.view.ResultView;
import lotto.view.WinNumbers;

public class LottoController {
    private InputView inputView;
    private ResultView resultView;
    private BuyingLottos buyingLottos;
    
    public LottoController(final InputView inputView, final ResultView resultView) {
        this.inputView = inputView;
        this.resultView = resultView;
    }
    
    public void runBuyingLottoProcess() {
        inputView.printCashAnswer();
        buyingLottos = new BuyingLottos(inputView.getUserInputCashPayment());
        resultView.printLottos(buyingLottos);
    }
    
    public void runResultProcess() {
        WinNumbers winNumbers = inputView.getUserInputWinNumber();
        WanLottoNumbers wanLottoNumbers = new WanLottoNumbers(winNumbers.getWinNumbers(), winNumbers.getBonasWinNumber());
        resultView.printResult(buyingLottos.getOwnPrize(wanLottoNumbers));
    }
}
