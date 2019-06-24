package lotto.controller;

import lotto.domain.Lottos;
import lotto.domain.WinLotto;
import lotto.view.InputView;
import lotto.view.ResultView;

public class LottoController {
    private InputView consoleInputView;
    private ResultView consoleResultView;
    private Lottos lottos;
    private WinLotto winLotto;
    
    public LottoController(InputView consoleInputView, ResultView consoleResultView) {
        this.consoleInputView = consoleInputView;
        this.consoleResultView = consoleResultView;
        lottos = new Lottos();
    }
    
    public void runBuyingLottoProcess() {
        consoleInputView.printCashAnswer();
        lottos.buyLottos(consoleInputView.getUserInputCashPayment());
        consoleResultView.printLottos(lottos);
    }
    
    public void runResultProcess() {
        consoleInputView.printWinNumberAnswer();
        winLotto = new WinLotto(consoleInputView.getUserInputWinNumber());
    }
}
