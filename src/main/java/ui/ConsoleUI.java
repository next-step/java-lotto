package ui;

import domain.Lotto;
import view.InputView;
import view.ResultView;

import java.util.List;

public class ConsoleUI {

    public static void main(String[] args){

        int price = InputView.setLottoPayment();
        List<Lotto> lottos = InputView.buyLottoCount(price);
        Lotto lastLotto = InputView.lastLottoNumberList();
        ResultView.winStats(lottos, lastLotto);
        ResultView.winCalculate();
        int totalRewards = ResultView.winResult();
        ResultView.totalEarningRate(price,totalRewards);

    }
}
