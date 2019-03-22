package view;

import domain.LottoGame;
import domain.LottoResult;
import domain.Numbers;
import domain.WinningLotto;

public class ConsoleMain {
    public static void main(String[] args) {
        int money = InputView.getMoney();

        LottoGame lottoGame = new LottoGame(money);
        ResultView.printLottos(lottoGame);

        WinningLotto winningLotto = InputView.getWinningLotto();
        LottoResult result = lottoGame.figure(winningLotto);
        ResultView.printResult(result);
    }
}
