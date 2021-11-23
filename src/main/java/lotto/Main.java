package lotto;

import lotto.domain.Credit;
import lotto.domain.PurchaseMachine;
import lotto.view.InputView;
import lotto.view.ResultView;

import java.util.Scanner;

/**
 * @author han
 */
public class Main {

    public static void main(String[] args) {
        InputView inputView = new InputView(new Scanner(System.in));
        ResultView resultView = new ResultView();

        Credit credit = inputView.start();
        PurchaseMachine pm = new PurchaseMachine(credit);
        PurchaseMachine purchase = pm.purchase();
        resultView.printPurchaseLottos(purchase);
        PurchaseMachine purchaseMachineWithWonLotto = inputView.insertLastLotto(purchase);
        resultView.printResultStatics(purchaseMachineWithWonLotto);
    }
}
