package lotto;

import lotto.domain.Credit;
import lotto.domain.PurchaseMachine;
import lotto.domain.Statistics;
import lotto.domain.WonLotto;
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
        PurchaseMachine purchaseByCredit = new PurchaseMachine(credit);
        PurchaseMachine purchase = purchaseByCredit.purchase();

        resultView.printPurchaseLottos(purchase);

        WonLotto wonLotto = inputView.insertWonLotto();
        Statistics statistics = new Statistics(credit, purchase.getLottoList(), wonLotto);

        resultView.printResultStatics(statistics);
    }
}
