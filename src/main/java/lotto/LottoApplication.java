package lotto;

import lotto.domain.*;
import lotto.view.InputView;
import lotto.view.ResultView;

import java.util.ArrayList;
import java.util.List;

public class LottoApplication {
    public static void main(String[] args) {
        int initialAmount = InputView.inputLottoPurchaseAmount();
        int availableLottoCount = Lotto.calculateLottoCount(initialAmount);
        int manualCount = InputView.inputManualLottoCount();

        if (manualCount > 0) {
            InputView.printManualLottoGuide();
        }

        List<Lotto> manualLottos = new ArrayList<>();
        for (int i = 0; i < manualCount; i++) {
            Lotto lotto = new Lotto(InputView.inputManualLottoNumbers());
            manualLottos.add(lotto);
        }

        ResultView.printLottoCount(availableLottoCount, manualCount);
        Lottos lottos = new Lottos(availableLottoCount-manualCount, manualLottos);
        ResultView.printLottos(lottos);

        String winningNumber = InputView.inputWinningNumber();
        WinningNumbers winningNumbers = new WinningNumbers(winningNumber);
        BonusNumber bonusNumber = new BonusNumber(InputView.inputBonusNumber());
        ResultView.printResultOverview();

        Rewards result = lottos.getResult(winningNumbers, bonusNumber);
        ResultView.printResult(initialAmount, result);
    }
}
