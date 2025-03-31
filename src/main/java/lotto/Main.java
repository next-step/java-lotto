package lotto;

import lotto.domain.LottoGame;
import lotto.view.InputView;
import lotto.view.OutputView;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        LottoGame lottoGame = new LottoGame(InputView.inputPurchaseAmount());
        OutputView.printPurchaseList(lottoGame.getLottos());

        List<Integer> winningNumbers = InputView.inputWinningNumbers();
        int bonusNumber = InputView.inputBonusNumber();
        lottoGame.draw(winningNumbers, bonusNumber);

        OutputView.printWinningResult(lottoGame.getWinnerCounts());
        OutputView.printEarningRate(lottoGame.calculateEarningRate());
    }
}
