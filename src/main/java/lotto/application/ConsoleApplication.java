package lotto.application;

import lotto.Lotto;
import lotto.PurchaseHistory;
import lotto.RandomLottoGenerator;
import lotto.StatisticsResult;
import lotto.view.InputView;
import lotto.view.OutputView;

import java.util.Scanner;

public class ConsoleApplication {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        RandomLottoGenerator randomLottoGenerator = new RandomLottoGenerator();
        int amount = InputView.inputPurchaseAmount(scanner);
        PurchaseHistory purchase = new PurchaseHistory(amount, randomLottoGenerator);

        OutputView.printPurchaseResult(purchase);

        Lotto previousWinningLotto = InputView.inputPreviousWinningLotto(scanner);
        StatisticsResult statisticsResult = purchase.compareWith(previousWinningLotto);

        OutputView.printStatisticsResult(statisticsResult);
    }
}
