package ui;

import lotto.Lotto;
import lotto.LottoFactory;
import lotto.WinningLotto;
import lotto.WinningResult;

import java.util.List;

public class Application {
    public static void main(String[] args) {
        InputView inputView = new InputView();
        WinningResult winningResult = new WinningResult();

        inputView.saveAmount();
        inputView.saveManualCount();
        inputView.saveManualLottos();
        inputView.saveAutoCount();

        List<Lotto> lottos = LottoFactory.generateLottoNumbers(inputView.autoCount);

        for (int i = 0; i < lottos.size(); i++) {
            System.out.println(lottos.get(i));
        }

        lottos.addAll(inputView.manualLottos);

        inputView.saveWinningNumber();
        inputView.saveBonusNumber();
        WinningLotto winningLotto = new WinningLotto(inputView.getWinningNumbers(), inputView.getBonusNumber());
        winningResult.calculateWinningResult(lottos, winningLotto);
        ResultView.printResult(winningResult.getWinningResult());

        ResultView.printRatioOfReturn(winningResult.calculateRateOfReturn(inputView.amount));
    }
}
