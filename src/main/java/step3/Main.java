package step3;

import step3.ui.InputView;

public class Main {
    public static void main(String[] args) {
        int amount = InputView.purchaseAmount();
        LottoGame lottoGame = new LottoGame(new Money(amount));

        String winNum = InputView.WinningNumbers();
        Lotto winningNumbers = lottoGame.getWinLottoNum(winNum);
        lottoGame.getStatistics(winningNumbers);

    }
}
