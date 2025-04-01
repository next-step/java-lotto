package lotto;

import lotto.domain.Lotto;
import lotto.domain.LottoAmount;
import lotto.domain.LottoGame;
import lotto.view.InputView;
import lotto.view.OutputView;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        int money = InputView.inputPurchaseAmount();
        LottoAmount manualLottoAmount = new LottoAmount(InputView.inputManualLottoAmount());

        List<Lotto> lottos = new ArrayList<>();
        if (manualLottoAmount.biggerThanZero()) {
            OutputView.printManualInputHeader();
            for (int i = 0; manualLottoAmount.isNotEqual(i); ++i) {
                lottos.add(Lotto.createManually(InputView.inputManualNumbers()));
            }
        }

        LottoGame lottoGame = new LottoGame(money, lottos);
        OutputView.printPurchaseList(manualLottoAmount, lottoGame.getLottos());

        List<Integer> winningNumbers = InputView.inputWinningNumbers();
        int bonusNumber = InputView.inputBonusNumber();
        lottoGame.draw(winningNumbers, bonusNumber);

        OutputView.printWinningResult(lottoGame.getWinnerCounts());
        OutputView.printEarningRate(lottoGame.calculateEarningRate());
    }
}
