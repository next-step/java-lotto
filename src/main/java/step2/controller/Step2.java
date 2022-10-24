package step2.controller;

import java.util.List;
import step2.domain.Lottos;
import step2.domain.WinningMachine;
import step2.domain.WinningResult;
import step2.view.PurchaseView;
import step2.view.WinningView;

public class Step2 {

    public static void main(String[] args) {
        int purchasedValue = PurchaseView.getPurchasedValue();
        int numberOfLottos = PurchaseView.getNumberOfLottos(purchasedValue);
        Lottos lottos = Lottos.from(numberOfLottos);
        PurchaseView.printLottos(lottos);
        List<Integer> winningNumbers = WinningView.getWinningNumbers();
        WinningResult winningResult = WinningMachine.getWinningResult(lottos, winningNumbers);
        WinningView.printWinningResult(winningResult, purchasedValue);
    }
}
