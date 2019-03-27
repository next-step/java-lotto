package lotto.application;

import lotto.*;
import lotto.generator.IntegratedLottoGenerator;
import lotto.service.LottoGame;
import lotto.view.InputView;
import lotto.view.OutputView;

import java.util.List;
import java.util.Scanner;

public class ConsoleApplication {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        LottoGame lottoGame = LottoGame.getInstance();

        int amount = InputView.inputPurchaseAmount(scanner);
        Money payment = new Money(amount);

        int numberOfManualLotto = InputView.inputNumberOfManualLotto(scanner);
        List<String> inputManualLottos = InputView.inputManualLotto(scanner, numberOfManualLotto);
        LottoOrder lottoOrder = new LottoOrder(payment, inputManualLottos);

        IntegratedLottoGenerator integeratedLottoGenerator = new IntegratedLottoGenerator(lottoOrder);
        Lottos purchasedLottos = lottoGame.purchase(integeratedLottoGenerator);

        OutputView.printPurchaseResult(purchasedLottos, numberOfManualLotto);

        String previousWinningLottoNumbers = InputView.inputPreviousWinningLotto(scanner);
        int bonusBallNumber = InputView.inputBonusBall(scanner);
        WinningLotto previousWinningLotto = integeratedLottoGenerator.generateWinningLotto(previousWinningLottoNumbers, bonusBallNumber);
        LottosResult lottosResult = lottoGame.analyse(purchasedLottos, previousWinningLotto, payment);

        OutputView.printStatisticsResult(lottosResult);
        scanner.close();
    }
}
