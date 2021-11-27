package lotto;

import lotto.domain.Credit;
import lotto.domain.Lotto;
import lotto.domain.PurchaseMachine;
import lotto.domain.Statistics;
import lotto.domain.WonLotto;
import lotto.view.InputView;
import lotto.view.ResultView;

import java.util.List;
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
        List<Lotto> lotto = purchaseByCredit.purchase();

        resultView.printPurchaseLottos(lotto);

        WonLotto wonLotto = inputView.insertWonLotto();
        Statistics statistics = new Statistics(credit, lotto, wonLotto);

        resultView.printResultStatics(statistics);
    }
}
