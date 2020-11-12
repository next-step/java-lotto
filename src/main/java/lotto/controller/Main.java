package lotto.controller;

import lotto.utils.PurchaseCalculator;
import lotto.view.InputView;
import lotto.view.ResultView;

public class Main {
    public static void main(String[] args) {
        int money = InputView.askPurchaseMoney();
        int numOfLottos = PurchaseCalculator.getNumOfLottos(money);
        ResultView.printNumOfLottos(numOfLottos);

        String winningLotto = InputView.askWinningLotto();
        System.out.println(winningLotto);
    }
}
