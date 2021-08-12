package lotto;

import lotto.model.*;
import lotto.view.InputView;
import lotto.view.ResultView;

import java.util.ArrayList;
import java.util.List;

public class LottoApp {
    private static final int INPUTABLE_MIN_MANUAL_LOTTO_COUNT = 1;

    private final InputView inputView;
    private final ResultView resultView;

    private LottoApp() {
        this.inputView = new InputView();
        this.resultView = new ResultView();
    }

    public static void main(String[] args) {
        LottoApp lottoApp = new LottoApp();
        lottoApp.run();
    }

    private void run() {
        inputView.printPurchasePriceInputMessage();
        int purchaseAmount = inputView.inputPurchasePrice();
        inputView.executeNextLine();
        inputView.printNewLine();

        inputView.printManualLottoCountInputMessage();
        int manualLottoCount = inputView.inputManualLottoCount();
        inputView.printNewLine();

        if (manualLottoCount >= INPUTABLE_MIN_MANUAL_LOTTO_COUNT) {
            inputView.printManualLottosInputMessage();
        }

        List<Lotto> manualLottos = new ArrayList<>();
        for (int i = 0; i < manualLottoCount; i++) {
            manualLottos.add(new Lotto(inputView.inputManualLotto()));
        }

        Lottos lottos = new Lottos(purchaseAmount, manualLottos);
        resultView.printLottoCount(lottos.getSize(), manualLottoCount);
        resultView.printLottos(lottos);

        inputView.printWinningNumbersInputMessage();
        Lotto winningNumbers = new Lotto(inputView.inputWinningNumbers());
        inputView.printBonusNumberInputMessage();
        List<WinningRank> winningRanks = WinningRank.findWinningRanks(lottos, new DrawNumbers(winningNumbers,
                LottoNumber.valueOf(inputView.inputBonusNumber())));

        resultView.printNewLine();
        resultView.printWinningStatistics(purchaseAmount, winningRanks);
    }
}
