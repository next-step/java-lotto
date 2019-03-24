package lotto.application;

import lotto.*;
import lotto.view.InputView;
import lotto.view.OutputView;

import java.util.List;
import java.util.Scanner;

public class ConsoleApplication {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        LottoGenerator randomLottoGenerator = RandomLottoGenerator.getInstance();
        LottoGame lottoGame = LottoGame.getInstance(randomLottoGenerator);

        int amount = InputView.inputPurchaseAmount(scanner);
        Money payment = new Money(amount);

        int numberOfManualLotto = InputView.inputNumberOfManualLotto(scanner);
        List<String> manualLotto = InputView.inputManualLotto(scanner, numberOfManualLotto);
        PurchasedLottos purchase = lottoGame.purchase(payment, manualLotto);

        OutputView.printPurchaseResult(purchase);

        String previousWinningLottoNumbers = InputView.inputPreviousWinningLotto(scanner);
        int bonusBallNumber = InputView.inputBonusBall(scanner);
        WinningLotto previousWinningLotto = randomLottoGenerator.generateWinningLotto(previousWinningLottoNumbers, bonusBallNumber);
        LottosResult lottosResult = lottoGame.analyse(purchase, previousWinningLotto, payment);

        OutputView.printStatisticsResult(lottosResult);
        scanner.close();
    }
}
