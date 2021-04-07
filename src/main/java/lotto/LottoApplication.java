package lotto;

import lotto.view.InputView;

public class LottoApplication {
    public static void main(String[] args) {
        InputView inputView = new InputView();
        int buyMoney = inputView.getBuyLottoAmount();
        LottoGame lottoGame = new LottoGame();

        lottoGame.buyLotto(buyMoney);

        String winningNumber = inputView.getLastWinningNumbers();
        lottoGame.lastWinningLotto(winningNumber);

        lottoGame.lottoWinners();

    }
}
