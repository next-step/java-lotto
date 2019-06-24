package lotto.controller;

import lotto.domain.BuyingLottos;
import lotto.domain.WinLottoNumbers;
import lotto.view.InputView;
import lotto.view.ResultView;

public class LottoController {
    private InputView consoleInputView;
    private ResultView consoleResultView;
    private BuyingLottos buyingLottos;
    private WinLottoNumbers winLottoNumbers;
    
    public LottoController(InputView consoleInputView, ResultView consoleResultView) {
        this.consoleInputView = consoleInputView;
        this.consoleResultView = consoleResultView;
        buyingLottos = new BuyingLottos();
    }
    
    public void runBuyingLottoProcess() {
        consoleInputView.printCashAnswer();
        buyingLottos.buyLottos(consoleInputView.getUserInputCashPayment());
        consoleResultView.printLottos(buyingLottos);
    }
    
    public void runResultProcess() {
        consoleInputView.printWinNumberAnswer();
        winLottoNumbers = new WinLottoNumbers(consoleInputView.getUserInputWinNumber());
        consoleResultView.printResult(buyingLottos.getOwnPrize(winLottoNumbers));
    }
}
