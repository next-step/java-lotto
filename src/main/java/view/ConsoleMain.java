package view;

import domain.LottoGame;
import domain.LottoResult;
import domain.Numbers;

public class ConsoleMain {
    public static void main(String[] args) {
        int money = InputView.getMoney();

        LottoGame lottoGame = new LottoGame(money);
        ResultView.printLottos(lottoGame);

        Numbers winNumbers = InputView.getWinNumbers();
        LottoResult result = lottoGame.figure(winNumbers);
        ResultView.printResult(result);
    }
}
