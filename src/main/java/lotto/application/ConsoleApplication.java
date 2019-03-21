package lotto.application;

import lotto.*;
import lotto.view.InputView;
import lotto.view.OutputView;

import java.util.List;
import java.util.Scanner;

public class ConsoleApplication {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        RandomLottoGenerator randomLottoGenerator = new RandomLottoGenerator();
        int amount = InputView.inputPurchaseAmount(scanner);
        PurchaseHistory purchase = LottoGame.purchase(amount, randomLottoGenerator);

        OutputView.printPurchaseResult(purchase);

        List<Integer> previousWinningLottoNumbers = InputView.inputPreviousWinningLotto(scanner);
        Lotto previousWinningLotto = new FixedLottoGenerator(previousWinningLottoNumbers).generateLotto();

        StatisticsResult statisticsResult = LottoGame.analyse(purchase, previousWinningLotto);

        OutputView.printStatisticsResult(statisticsResult);
        scanner.close();
    }
}
