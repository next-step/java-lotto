package view;

import domain.Lotto;
import domain.LottoGame;
import domain.LottoResult;

public class ConsoleMain {
    public static void main(String[] args) {
        int money = InputView.getMoney();

        LottoGame lottoGame = new LottoGame(money);
        ResultView.printLottos(lottoGame);

        Lotto winLotto = InputView.getWinLotto();
        LottoResult result = lottoGame.lottery(winLotto);
        ResultView.printResult(result);
    }
}
