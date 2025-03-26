package lotto;

import lotto.domain.LottoGame;
import lotto.view.InputView;
import lotto.view.OutputView;

public class Main {
    public static void main(String[] args) {
        LottoGame lottoGame = new LottoGame(InputView.inputPurchaseAmount());
        OutputView.printPurchaseList(lottoGame.getLottos());

        lottoGame.draw(InputView.inputWinningNumbers());

        OutputView.printWinningResult(lottoGame.getWinnerCountMap());
        OutputView.printEarningRate(lottoGame.calculateEarningRate());
    }
}
