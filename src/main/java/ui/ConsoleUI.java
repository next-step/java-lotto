package ui;

import domain.LottoGame;
import view.InputView;
import view.ResultView;

public class ConsoleUI {
    public static void main(String[] args){
        int price = InputView.setLottoPayment();
        LottoGame lottoGame = new LottoGame(InputView.buyLottoCount(price), InputView.lastLottoNumber());
        ResultView.winStats(lottoGame);
        ResultView.totalEarningRate(price,lottoGame.winResult());
    }
}
