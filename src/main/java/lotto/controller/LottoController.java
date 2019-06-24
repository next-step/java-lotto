package lotto.controller;

import lotto.domain.BoughtLottos;
import lotto.domain.WinLottoNumbers;
import lotto.view.InputView;
import lotto.view.ResultView;

public class LottoController {
    private InputView consoleInputView;
    private ResultView consoleResultView;
    private BoughtLottos boughtLottos;
    private WinLottoNumbers winLottoNumbers;
    
    public LottoController(InputView consoleInputView, ResultView consoleResultView) {
        this.consoleInputView = consoleInputView;
        this.consoleResultView = consoleResultView;
        boughtLottos = new BoughtLottos();
    }
    
    public void runBuyingLottoProcess() {
        consoleInputView.printCashAnswer();
        boughtLottos.buyLottos(consoleInputView.getUserInputCashPayment());
        consoleResultView.printLottos(boughtLottos);
    }
    
    public void runResultProcess() {
        consoleInputView.printWinNumberAnswer();
        winLottoNumbers = new WinLottoNumbers(consoleInputView.getUserInputWinNumber());
        winLottoNumbers.getResult(boughtLottos);
    }
}
