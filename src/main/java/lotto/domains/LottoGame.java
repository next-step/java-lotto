package lotto.domains;

import lotto.ui.InputUI;
import lotto.ui.OutputUI;

import java.util.List;

public class LottoGame {
    public void run() {
        try{
            Cash cash = this.inputPurchasingAmount();
            List<String> manualLottosNumbers = this.inputManualLottoInformation(cash);
            Lottos lottos = this.buyLotto(cash, manualLottosNumbers);
            WinningLotto winningLotto = this.inputWinningLotto();
            this.compileStatistics(winningLotto, lottos);
        }catch (IllegalArgumentException illegalArgumentException) {
            System.out.println(illegalArgumentException.getMessage());
            run();
        }
    }

    private Lottos buyLotto(Cash cash, List<String> manualLottosNumbers) {
        PurchasingInfo purchasingInfo = new PurchasingInfo(cash, manualLottosNumbers);
        Lottos lottos = LottoMachine.makeLottos(purchasingInfo);
        OutputUI.printNumberOfPurchases(lottos);
        OutputUI.printLottosNumbers(lottos);
        return lottos;
    }

    private Cash inputPurchasingAmount() {
        OutputUI.printInputPurchasingAmount();
        return new Cash(InputUI.inputPurchasingAmount());
    }

    private List<String> inputManualLottoInformation(Cash cash) {
        OutputUI.printInputManualLottoAmount();
        LottoCount manualLottoCount = new LottoCount(InputUI.inputManualLottoAmount(), cash);
        OutputUI.printInputManualLottosNumbers();
        return InputUI.inputManualLottosNumbers(manualLottoCount);
    }

    private WinningLotto inputWinningLotto() {
        OutputUI.printInputWinningLottoNumbers();
        String stringWinningNumbers = InputUI.inputWinningNumbers();
        OutputUI.printInputBonusNumber();
        int bonusNumber = InputUI.inputBonusNumber();
        return new WinningLotto(stringWinningNumbers, bonusNumber);
    }

    private void compileStatistics(WinningLotto winningLotto, Lottos lottos) {
        lottos.matchingWinningNumbersAndBonusNumber(winningLotto);
        OutputUI.printStatistics(lottos);
        OutputUI.printRateOfReturn(lottos);
    }
}
